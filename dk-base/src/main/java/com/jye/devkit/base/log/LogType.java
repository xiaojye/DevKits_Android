package com.jye.devkit.base.log;

import android.util.Log;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author jye
 * @since 1.0
 */
public class LogType {
    @IntDef({D, I, W, E})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TYPE {
    }

    public final static int D = Log.DEBUG;
    public final static int I = Log.INFO;
    public final static int W = Log.WARN;
    public final static int E = Log.ERROR;
}
