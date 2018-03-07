package com.onion.taxi.engine.splash;

import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.onion.base.RouterPath;
import com.onion.base.mvp.IBasePresenter;
import com.onion.base.ui.BaseActivity;
import com.onion.taxi.R;
import com.onion.taxi.di.ActivityComponent;

import javax.inject.Inject;

/**
 * Created by OnionMac on 2018/3/6.
 */
@Route(path = RouterPath.TAXI_SPLASH)
public class SplashActivity extends BaseActivity implements SplashContract.View{

    @Inject
    SplashPresenter mPresenter;

    @Override
    protected void inJect() {
        ActivityComponent
                .getInstance()
                .inject(this);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.taxi_activity_main);
        findViewById(R.id.tv).setOnClickListener(v -> mPresenter.getCode());
    }

    @Override
    protected IBasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void getCodeSuccess(String code) {
        Log.d("zhangqi", "getCodeSuccess: "+code);
    }
}
