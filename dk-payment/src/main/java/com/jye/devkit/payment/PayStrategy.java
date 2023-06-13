package com.jye.devkit.payment;

import android.content.Context;

/**
 * @author jye
 */
public abstract class PayStrategy<P extends PayParam> {

    protected Context context;

    protected void setContext(Context context) {
        this.context = context;
    }

    public abstract void doPay(P param, PayCallback callback);
}
