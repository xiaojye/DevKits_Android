package com.jye.devkit.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;

import com.jye.devkit.base.log.LogConfig;

/**
 * @author jye
 * @since 1.0
 */
public final class DkBase {

    private static Application sApplication;
    private static Handler sMainHandler;

    public static LogConfig sLogConfig;

    private DkBase() {
        throw new UnsupportedOperationException();
    }

    /**
     * 初始化
     *
     * @param application Application
     */
    public static void init(Application application) {
        init(application, new LogConfig());
    }

    /**
     * 初始化
     *
     * @param application Application
     * @param logConfig   自定义日志配置
     */
    public static void init(Application application, LogConfig logConfig) {
        sApplication = application;
        sMainHandler = new Handler(Looper.getMainLooper());
        sLogConfig = logConfig;
    }

    /**
     * 获取全局 Application
     *
     * @return Application
     */
    public static Application getApp() {
        return sApplication;
    }

    /**
     * 获取全局 Context
     *
     * @return ApplicationContext
     */
    public static Context getAppContext() {
        return getApp().getApplicationContext();
    }

    /**
     * 获取全局资源对象
     *
     * @return Resources
     */
    public static Resources getResources() {
        return getApp().getResources();
    }

    /**
     * 获取主线程Handler
     *
     * @return Handler
     */
    public static Handler getMainHandler() {
        return sMainHandler;
    }

    /**
     * 在主线程中执行异步操作
     *
     * @param runnable 异步操作线程
     */
    public static void runOnUiThread(Runnable runnable) {
        getMainHandler().post(runnable);
    }
}
