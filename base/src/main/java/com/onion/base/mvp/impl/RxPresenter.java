package com.onion.base.mvp.impl;

import com.onion.base.mvp.IBasePresenter;
import com.onion.base.mvp.IBaseView;
import com.onion.base.repository.IRepository;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by OnionMac on 2018/3/6.
 */

public class RxPresenter<V extends IBaseView,A extends IRepository> implements IBasePresenter<V>{

    protected V mView;

    protected A mRepository;

    public CompositeDisposable mCompositeDisposable;

    public RxPresenter(CompositeDisposable compositeDisposable,A repository){
        mCompositeDisposable = compositeDisposable;
        mRepository = repository;
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

    protected void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    protected void addSubscribe(Disposable subscription) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }

}
