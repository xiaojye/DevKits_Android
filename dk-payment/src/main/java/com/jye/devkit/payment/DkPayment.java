package com.jye.devkit.payment;

import android.content.Context;

/**
 * @author jye
 */
public class DkPayment {

    public static PayStrategy createStrategy(Context context, PayChannel channel) throws Exception {
        String className = channel.getClassName();
        PayStrategy strategy = (PayStrategy) Class.forName(className).newInstance();
        strategy.setContext(context);
        return strategy;
    }
}
