package com.jye.devkit.base.log.format;

import com.jye.devkit.base.log.LogConfig;
import com.jye.devkit.base.log.LogItem;

/**
 * 内容格式化结构
 *
 * @author jye
 * @since 1.0
 */
public interface LogFormatter {

    String format(LogConfig config, LogItem item);
}
