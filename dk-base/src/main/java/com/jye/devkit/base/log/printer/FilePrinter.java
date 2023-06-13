package com.jye.devkit.base.log.printer;

import android.os.AsyncTask;

import com.jye.devkit.base.log.format.LogFormatter;
import com.jye.devkit.base.log.LogConfig;
import com.jye.devkit.base.log.LogItem;
import com.jye.devkit.base.log.LogType;
import com.jye.devkit.base.util.IOUtils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * 文件打印
 *
 * @author jye
 * @since 1.0
 */
public class FilePrinter extends LogPrinter {
    private static final DateFormat FILE_NAME_FORMAT = new SimpleDateFormat("yyyyMMdd");
    private static final DateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    private final String mDirPath;

    public FilePrinter(LogFormatter formatter, String dirPath) {
        super(formatter);
        this.mDirPath = dirPath;
    }

    @Override
    public void print(LogConfig config, LogItem item) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                String fileName = FILE_NAME_FORMAT.format(item.getTimeMillis()) + ".log";
                File file = new File(mDirPath, fileName);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

//        2023-03-27 20:05:57.308 pid-tid $LEVEL $TAG: $内容
                String time = TIME_FORMAT.format(item.getTimeMillis());
                int pid = item.getPid();
                long tid = item.getTid();
                String levelStr;
                switch (item.getLevel()) {
                    default:
                    case LogType.D:
                        levelStr = "D";
                        break;
                    case LogType.I:
                        levelStr = "I";
                        break;
                    case LogType.W:
                        levelStr = "W";
                        break;
                    case LogType.E:
                        levelStr = "E";
                        break;
                }
                String prefix = String.format("%s\t%d-%d\t%s\t%s: ", time, pid, tid, levelStr, item.getTag());
                String printString = formatter.format(config, item);
                if (printString.contains("\n")) {
                    String[] split = printString.split("\n");
                    String spaceWidgetByPrefix = getSpaceWidgetByStr(prefix);
                    for (int i = 0; i < split.length; i++) {
                        String s = split[i];
                        if (i == 0) {
                            IOUtils.writeFileFromString(file, prefix + s + "\n", true);
                        } else {
                            IOUtils.writeFileFromString(file, spaceWidgetByPrefix + s + "\n", true);
                        }
                    }
                } else {
                    IOUtils.writeFileFromString(file, prefix + "\t" + printString + "\n", true);
                }
            }
        });
    }

    private String getSpaceWidgetByStr(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

}
