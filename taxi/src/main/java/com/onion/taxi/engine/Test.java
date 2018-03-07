package com.onion.taxi.engine;

import com.onion.base.mvp.IBasePresenter;
import com.onion.base.ui.BaseActivity;
import com.onion.taxi.di.ActivityComponent;
import com.onion.taxi.engine.splash.SplashContract;
import com.onion.taxi.engine.splash.SplashPresenter;

import javax.inject.Inject;

/**
 * Created by OnionMac on 2018/3/6.
 */

public class Test extends BaseActivity implements SplashContract.View{

    @Inject
    SplashPresenter mSplashPresenter;

    @Override
    protected void initView() {
        mSplashPresenter.getCode();
    }

    @Override
    protected void inJect() {
        ActivityComponent.getInstance().inject(this);
    }

    @Override
    protected IBasePresenter getPresenter() {
        return mSplashPresenter;
    }

    @Override
    public void getCodeSuccess(String code) {
    }
}
