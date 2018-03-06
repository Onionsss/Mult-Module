package com.onion.http.api;

import android.util.Log;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by OnionMac on 17/9/22.
 *
 * http基本log
 */

public class HttpLogger implements HttpLoggingInterceptor.Logger {

    private static final String HTTPLOG = "httpLog";

    private static boolean OPEN = false;

    public static boolean setOpenFlag(boolean open){
        OPEN = open;
        return OPEN;
    }

    public static boolean getOpenFlag(){
        return OPEN;
    }

    @Override
    public void log(String message) {
        if(OPEN){
            Log.d(HTTPLOG, message);
        }
    }
}