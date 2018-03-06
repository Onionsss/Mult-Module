package com.onion.base.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.onion.base.mvp.IBasePresenter;
import com.onion.base.mvp.IBaseView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by OnionMac on 2018/3/6.
 *
 * rxjava层 抽象presenter
 *
 */

public abstract class RxActivity extends MessageActivity implements IBaseView{

    private CompositeDisposable mCompositeSubscription;

    /**
     * 利用presenter获得mCompositeSubscription
     */
    private IBasePresenter mIBasePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setPresenter(getPresenter());

        /**
         * 取消网络请求
         */
        mProgressDialog.setOnCancelListener(dialog -> {
            if(mCompositeSubscription != null){
                mCompositeSubscription.clear();
            }
        });

    }

    protected void setPresenter(IBasePresenter iBasePresenter) {
        mIBasePresenter = iBasePresenter;
        if(iBasePresenter != null){
            iBasePresenter.attachView(this);
        }
        mCompositeSubscription = iBasePresenter.getCompositeDisposable();
    }

    protected abstract IBasePresenter getPresenter();

    public CompositeDisposable getCompositeSubscription() {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeDisposable();
        }
        return this.mCompositeSubscription;
    }

    public void addSubscription(Disposable s) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeDisposable();
        }
        this.mCompositeSubscription.add(s);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 释放Presenter
         */
        if(mIBasePresenter != null){
            mIBasePresenter.detachView();
        }

        /**
         * 释放CompositeSubscription
         */
        if(mCompositeSubscription != null)
            mCompositeSubscription.clear();
    }
}
