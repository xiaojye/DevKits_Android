package com.jye.devkit.base.log;

import com.jye.devkit.base.log.format.SimpleFormatter;
import com.jye.devkit.base.log.printer.LogPrinter;
import com.jye.devkit.base.log.printer.LogcatPrinter;
import com.jye.devkit.base.DkBase;
import com.jye.devkit.base.util.AppInfoUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jye
 * @since 1.0
 */
public class LogConfig {

    private boolean enable = true;
    private String tag;
    private boolean includeThread = false;
    private boolean includeStackTrace = false;
    private int stackTraceDepth = 10;
    private List<LogPrinter> printers = new ArrayList<>();

    public LogConfig() {
        printers.add(new LogcatPrinter(new SimpleFormatter()));
    }

    public LogConfig(LogConfig copy) {
        this.enable = copy.enable;
        this.tag = copy.tag;
        this.includeThread = copy.includeThread;
        this.includeStackTrace = copy.includeStackTrace;
        this.stackTraceDepth = copy.stackTraceDepth;
        this.printers = copy.printers;
    }

    public boolean isEnable() {
        return enable;
    }

    public LogConfig setEnable(boolean enable) {
        this.enable = enable;
        return this;
    }

    public String getTag() {
        if (tag == null || tag.isEmpty()) {
            tag = AppInfoUtils.getAppName(DkBase.getAppContext());
        }
        return tag;
    }

    public LogConfig setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public boolean isIncludeThread() {
        return includeThread;
    }

    public LogConfig setIncludeThread(boolean includeThread) {
        this.includeThread = includeThread;
        return this;
    }

    public boolean isIncludeStackTrace() {
        return includeStackTrace;
    }

    public LogConfig setIncludeStackTrace(boolean includeStackTrace) {
        this.includeStackTrace = includeStackTrace;
        return this;
    }

    public int getStackTraceDepth() {
        return stackTraceDepth;
    }

    public LogConfig setStackTraceDepth(int stackTraceDepth) {
        this.stackTraceDepth = stackTraceDepth;
        return this;
    }

    public List<LogPrinter> getPrinters() {
        return printers;
    }

    public LogConfig addPrinter(LogPrinter... printers) {
        this.printers.addAll(Arrays.asList(printers));
        return this;
    }

}
