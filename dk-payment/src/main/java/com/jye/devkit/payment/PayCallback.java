package com.jye.devkit.payment;

/**
 * 支付回调接口
 *
 * @author jye
 * @since 1.0
 */
public interface PayCallback {

    /**
     * 支付成功
     */
    void onSuccess();

    /**
     * 支付失败
     *
     * @param errCode 错误码
     * @param errMsg  错误信息
     */
    void onFailure(int errCode, String errMsg);

    /**
     * 支付取消
     */
    void onCancel();
}