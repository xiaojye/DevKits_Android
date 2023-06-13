package com.jye.devkit.sample;

import android.app.Application;
import android.content.Context;

import com.jye.devkit.base.DkBase;
import com.jye.devkit.base.log.LogConfig;
import com.jye.devkit.base.log.format.LogFormatter;
import com.jye.devkit.base.log.format.SimpleFormatter;
import com.jye.devkit.base.log.printer.DbPrinter;
import com.jye.devkit.base.log.printer.FilePrinter;
import com.jye.devkit.base.log.printer.LogPrinter;

/**
 * Created by jye on 2023/3/27.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LogFormatter simpleFormatter = new SimpleFormatter();
        String logDir = getDir("log", Context.MODE_PRIVATE).getAbsolutePath();
        LogPrinter filePrinter = new FilePrinter(simpleFormatter, logDir);
        LogPrinter dbPrinter = new DbPrinter(this, simpleFormatter, logDir + "/mylog.db");
        DkBase.init(this, new LogConfig()
                .setIncludeThread(true)
                .setIncludeStackTrace(true)
                .addPrinter(filePrinter, dbPrinter));
    }
}
