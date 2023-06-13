package com.jye.devkit.payment.alipay;

import com.jye.devkit.payment.PayParam;

/**
 * @author jye
 */
public class AliPayParam extends PayParam {

    private String orderInfo;

    public String getOrderInfo() {
        return orderInfo;
    }

    public AliPayParam setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
        return this;
    }
}
