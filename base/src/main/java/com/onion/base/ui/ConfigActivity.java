package com.onion.base.ui;

import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by OnionMac on 2018/3/6.
 */

public class ConfigActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * 主线程
     * @return
     */
    protected boolean isMainThread(){
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
