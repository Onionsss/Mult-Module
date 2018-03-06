package com.onion.base.mvp;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by OnionMac on 2018/3/6.
 */

public interface IBasePresenter<V extends IBaseView> {

    void attachView(V view);

    void detachView();

    V getView();

    CompositeDisposable getCompositeDisposable();

}
