package com.jye.devkit.base.log.printer;

import android.util.Log;

import com.jye.devkit.base.log.format.LogFormatter;
import com.jye.devkit.base.log.LogConfig;
import com.jye.devkit.base.log.LogItem;
import com.jye.devkit.base.log.LogType;

/**
 * 控制台打印
 *
 * @author jye
 * @since 1.0
 */
public class LogcatPrinter extends LogPrinter {
    private static final int MAX_LEN = 512;

    public LogcatPrinter(LogFormatter formatter) {
        super(formatter);
    }

    @Override
    public void print(LogConfig config, LogItem item) {
        int priority;
        switch (item.getLevel()) {
            default:
            case LogType.D:
                priority = Log.DEBUG;
                break;
            case LogType.I:
                priority = Log.INFO;
                break;
            case LogType.W:
                priority = Log.WARN;
                break;
            case LogType.E:
                priority = Log.ERROR;
                break;
        }
        String printString = formatter.format(config, item);

        int len = printString.length();
        int countOfSub = len / MAX_LEN;
        if (countOfSub > 0) {
            StringBuilder log = new StringBuilder();
            int index = 0;
            for (int i = 0; i < countOfSub; i++) {
                log.append(printString.substring(index, index + MAX_LEN));
                index += MAX_LEN;
            }
            if (index != len) {
                log.append(printString.substring(index, len));
            }
            Log.println(priority, item.getTag(), log.toString());
        } else {
            Log.println(priority, item.getTag(), printString);
        }
    }

}
