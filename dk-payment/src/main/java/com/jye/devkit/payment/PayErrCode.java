package com.jye.devkit.payment;

/**
 * @author jye
 */
public class PayErrCode {
    public static final int UNKNOWN = -1; //支付失败
    public static final int UNSUPPORT = 1000; //未安装APP或不支持支付
    public static final int PARAMETER_INVALID = 1001; //参数无效

    public static final String ALIPAY_SUCCESS = "9000"; //订单支付成功
    public static final String ALIPAY_HANDLING = "8000"; //正在处理中
    public static final String ALIPAY_CANCEL = "6001"; //用户中途取消
    public static final String ALIPAY_NETWORK = "6002"; //网络连接出错
}
