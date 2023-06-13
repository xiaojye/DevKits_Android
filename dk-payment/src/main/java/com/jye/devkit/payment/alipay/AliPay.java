package com.jye.devkit.payment.alipay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.alipay.sdk.app.PayTask;
import com.jye.devkit.payment.PayCallback;
import com.jye.devkit.payment.PayErrCode;
import com.jye.devkit.payment.PayStrategy;

import java.util.Map;

/**
 * @author jye
 */
public class AliPay extends PayStrategy<AliPayParam> {
    private static final int SDK_PAY_FLAG = 1;

    private Context mContext;
    private PayCallback mPayCallback;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    AliPayResult payResult = new AliPayResult((Map<String, String>) msg.obj);
                    /**
                     * 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, PayErrCode.ALIPAY_SUCCESS)) {
                        if (mPayCallback != null) {
                            mPayCallback.onSuccess();
                        }
                    } else {
                        //支付取消
                        if (TextUtils.equals(resultStatus, PayErrCode.ALIPAY_CANCEL)) {
                            if (mPayCallback != null) {
                                mPayCallback.onCancel();
                            }
                        }
                        //网络连接出错
                        else if (TextUtils.equals(resultStatus, PayErrCode.ALIPAY_NETWORK)) {
                            if (mPayCallback != null) {
                                mPayCallback.onFailure(Integer.parseInt(resultStatus), "网络连接出错");
                            }
                        }
                        //支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        else if (TextUtils.equals(resultStatus, PayErrCode.ALIPAY_HANDLING)) {
                            mPayCallback.onFailure(Integer.parseInt(resultStatus), "支付处理中");
                        }
                        //支付失败
                        else {
                            if (mPayCallback != null) {
                                mPayCallback.onFailure(PayErrCode.UNKNOWN, "支付失败");
                            }
                        }
                    }
                    break;
                }
            }
        }
    };

    @Override
    protected void setContext(Context context) {
        this.mContext = context;
    }

    @Override
    public void doPay(AliPayParam param, PayCallback callback) {
        this.mPayCallback = callback;

        // 1、参数校验
        if (param == null || TextUtils.isEmpty(param.getOrderInfo())) {
            callback.onFailure(PayErrCode.PARAMETER_INVALID, "支付参数为空");
            return;
        }

        // 2、实现支付相关逻辑
        final String orderInfo = param.getOrderInfo(); // 订单信息
        // 必须异步调用
        new Thread(new Runnable() {
            @Override
            public void run() {
                PayTask alipay = new PayTask((Activity) mContext);
                Map<String, String> result = alipay.payV2(orderInfo, true);
                Log.i("msp", result.toString());

                // 3、回调支付结果
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        }).start();
    }
}
