package com.jye.devkit.base.log.format;

import com.jye.devkit.base.log.LogItem;
import com.jye.devkit.base.log.LogConfig;

/**
 * Created by jye on 2023/3/27.
 */
public class SimpleFormatter implements LogFormatter {

    @Override
    public String format(LogConfig config, LogItem item) {

        StringBuilder sb = new StringBuilder();

        //日志内容
        sb.append(item.getContent());

        //线程信息
        if (config.isIncludeThread()) {
            sb.append("\nThread: ").append(String.format("id=%d, name=%s", item.getThread().getId(), item.getThread().getName()));
        }

        //堆栈信息
        if (config.isIncludeStackTrace()) {
            sb.append("\nStackTrace: \n");
            for (int i = 0, len = item.getStackTrace().length; i < len; i++) {
                if (i != len - 1) {
                    sb.append("    ├ ");
                    sb.append(item.getStackTrace()[i].toString());
                    sb.append("\n");
                } else {
                    sb.append("    └ ");
                    sb.append(item.getStackTrace()[i].toString());
                }
            }
        }

        return sb.toString();
    }

}
