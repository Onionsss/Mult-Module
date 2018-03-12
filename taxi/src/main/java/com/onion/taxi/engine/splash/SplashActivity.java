package com.onion.taxi.engine.splash;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.onion.base.RouterPath;
import com.onion.base.center.AppCenter;
import com.onion.base.di.module.ActivityModule;
import com.onion.base.mvp.IBasePresenter;
import com.onion.base.ui.BaseActivity;
import com.onion.taxi.R;
import com.onion.taxi.databinding.TaxiActivityMainBinding;
import com.onion.taxi.di.DaggerActivityComponent;
import com.onion.util.StatusBarUtil;

import javax.inject.Inject;

/**
 * Created by OnionMac on 2018/3/6.
 */
@Route(path = RouterPath.TAXI_SPLASH)
public class SplashActivity extends BaseActivity implements SplashContract.View{

    @Inject
    SplashContract.Presenter mPresenter;

    @Override
    protected void inJect() {
        DaggerActivityComponent
                .builder()
                .appComponent(AppCenter.getAppComponent())
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {
        TaxiActivityMainBinding taxi = DataBindingUtil.setContentView(this, R.layout.taxi_activity_main);
        StatusBarUtil.StatusBarLightMode(this);
        StatusBarUtil.setColor(this, Color.WHITE,0);

        AnimatedVectorDrawable drawable = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.splash_logo_anim);
        taxi.splashImg.setImageDrawable(drawable);
        taxi.splashImg.postDelayed(() -> {
            drawable.start();
            taxi.splashImg.setVisibility(View.VISIBLE);
            taxi.splashTv.setVisibility(View.VISIBLE);
        },1000);

        mPresenter.getCode();
    }

    @Override
    protected IBasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void getCodeSuccess(String code) {
        showMsg(code);
    }
}
