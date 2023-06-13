package com.jye.devkit.base.log;

import android.os.Process;

import androidx.annotation.NonNull;

import com.jye.devkit.base.DkBase;
import com.jye.devkit.base.log.printer.LogPrinter;
import com.jye.devkit.base.util.StackTraceUtils;

import java.util.List;

/**
 * Tips:
 * 1.打印堆栈信息
 * 2.File输出
 * 3.模拟控制台
 *
 * @author jye
 * @since 1.0
 */
public class DkLog {

    private static final String LOG_PACKAGE;

    //static{}(即static块)，会在类被加载的时候执行且仅会被执行一次，一般用来初始化静态变量和调用静态方法，
    static {
        String className = DkLog.class.getName();
        LOG_PACKAGE = className.substring(0, className.lastIndexOf('.') + 1);
    }

    /**
     * 打印debug级别的日志，可以传入格式化参数。
     */
    public static void d(String format, Object... args) {
        log(LogType.D, String.format(format, args));
    }

    /**
     * 打印debug级别的日志，可以传入格式化参数。（含tag）
     */
    public static void d(String tag, String format, Object... args) {
        log(LogType.D, tag, String.format(format, args));
    }

    /**
     * 打印info级别的日志，可以传入格式化参数。
     */
    public static void i(String format, Object... args) {
        log(LogType.I, String.format(format, args));
    }

    /**
     * 打印info级别的日志，可以传入格式化参数。（含tag）
     */
    public static void i(String tag, String format, Object... args) {
        log(LogType.I, tag, String.format(format, args));
    }

    /**
     * 打印warn级别的日志，可以传入格式化参数。
     */
    public static void w(String format, Object... args) {
        log(LogType.W, String.format(format, args));
    }

    /**
     * 打印warn级别的日志，可以传入格式化参数。（含tag）
     */
    public static void w(String tag, String format, Object... args) {
        log(LogType.W, tag, String.format(format, args));
    }

    /**
     * 打印error级别的日志，可以传入格式化参数。
     */
    public static void e(String format, Object... args) {
        log(LogType.E, String.format(format, args));
    }

    /**
     * 打印error级别的日志，可以传入格式化参数。（含tag）
     */
    public static void e(String tag, String format, Object... args) {
        log(LogType.E, tag, String.format(format, args));
    }

    public static void log(@LogType.TYPE int type, Object content) {
        log(type, DkBase.sLogConfig.getTag(), content);
    }

    public static void log(@LogType.TYPE int type, @NonNull String tag, Object content) {
        log(DkBase.sLogConfig, type, tag, content);
    }

    public static void log(LogConfig config, @LogType.TYPE int type, @NonNull String tag, Object content) {
        if (!config.isEnable()) {
            return;
        }

        //打印log
        List<LogPrinter> printers = config.getPrinters();
        for (LogPrinter printer : printers) {
            int myPid = Process.myPid();
            int myTid = Process.myTid();
            Thread thread = Thread.currentThread();
            StackTraceElement[] stackTrace = StackTraceUtils.getCroppedRealStackTrack(new Throwable().getStackTrace(), LOG_PACKAGE, config.getStackTraceDepth());
            printer.print(config, new LogItem(type, config.getTag() + "-" + tag, content.toString(), myPid, myTid, thread, stackTrace));
        }
    }

}
