package com.onion.base.mvp.impl;

import com.onion.base.mvp.IBasePresenter;
import com.onion.base.mvp.IBaseView;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by OnionMac on 2018/3/6.
 */

public class RxPresenter<V extends IBaseView> implements IBasePresenter<V>{

    protected V mView;

    public CompositeDisposable mCompositeDisposable;

    public RxPresenter(CompositeDisposable compositeDisposable){
        mCompositeDisposable = compositeDisposable;
    }

    /**
     * 绑定View
     * @param view
     */
    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    @Override
    public V getView() {
        return mView;
    }

    @Override
    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }
}
