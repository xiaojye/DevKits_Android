package com.jye.devkit.base.http.provider;

import com.jye.devkit.base.log.DkLog;

import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author jye
 * @since 1.0
 */
public class DefaultProvider implements IHttpProvider {

    @Override
    public int connectTimeout() {
        return 10;
    }

    @Override
    public int readTimeout() {
        return 10;
    }

    @Override
    public int writeTimeout() {
        return 10;
    }

    @Override
    public Interceptor[] interceptors() {
        return null;
    }

    @Override
    public HttpLoggingInterceptor.Logger logger() {
        return new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                DkLog.i(message);
            }
        };
    }
}
