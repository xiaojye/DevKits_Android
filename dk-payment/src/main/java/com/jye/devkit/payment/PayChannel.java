package com.jye.devkit.payment;

/**
 * @author jye
 */
public enum PayChannel {
    ALI_PAY("com.jye.devkit.payment.alipay.AliPay"),
    WX_PAY("com.jye.devkit.payment.wxpay.WxPay");

    private String className;

    PayChannel(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}