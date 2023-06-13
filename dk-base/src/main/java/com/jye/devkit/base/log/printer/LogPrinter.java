package com.jye.devkit.base.log.printer;

import com.jye.devkit.base.log.format.LogFormatter;
import com.jye.devkit.base.log.LogConfig;
import com.jye.devkit.base.log.LogItem;

/**
 * 日志打印接口
 *
 * @author jye
 * @since 1.0
 */
public abstract class LogPrinter {

    protected final LogFormatter formatter;

    public LogPrinter(LogFormatter formatter) {
        this.formatter = formatter;
    }

    public abstract void print(LogConfig config, LogItem item);
}
