package com.onion.taxi.engine.splash;

import com.onion.base.mvp.impl.RxPresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by OnionMac on 2018/3/6.
 */

public class SplashPresenter extends RxPresenter<SplashContract.View> implements SplashContract.Presenter{

    @Inject
    SplashPresenter(CompositeDisposable compositeDisposable) {
        super(compositeDisposable);
    }

    @Override
    public void getCode() {
        mView.getCodeSuccess("101");
    }
}
