package com.onion.base.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by OnionMac on 2018/3/6.
 *
 */

public abstract class BaseActivity extends RxActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        /**
         * 必须在此inject 不然会出现空指针
         */
        inJect();
        super.onCreate(savedInstanceState);

        initView();

        initData();

        initListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initDataOnStart();
    }

    @Override
    protected void onPause() {
        super.onPause();

        inPause();
    }

    /**
     * 暂停的时候
     */
    private void inPause() {

    }

    /**
     * 初始化视图
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected void initData(){}

    /**
     * 在onStart里做加载
     */
    protected void initDataOnStart(){}

    /**
     * 初始化监听
     */
    protected void initListener() {}

    /**
     * dagger依赖注入走这个方法
     */
    protected abstract void inJect();
}
