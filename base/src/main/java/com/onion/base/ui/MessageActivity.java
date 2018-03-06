package com.onion.base.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.onion.util.ToastUtil;
import com.onion.util.logger.Logger;
import com.onion.view.IOSLoadingDialog;
import com.onion.view.dialog.IDialog;

/**
 * Created by OnionMac on 2018/3/6.
 * 消息层activity 提供基本的动画和消息
 */

public class MessageActivity extends ConfigActivity{

    protected IDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IOSLoadingDialog.Builder loadBuilder = new IOSLoadingDialog.Builder(this)
                .setMessage("加载中...")
                .setShowMessage(false)
                .setCancelable(true)
                .setCancelOutside(false);
        mProgressDialog = loadBuilder.create();
    }

    public void showMsg(String msg){
        showMessage(msg);
    }

    public void showMessage(String msg){
        ToastUtil.showShort(this,msg);
    }

    public void showMessage(int strId){
        ToastUtil.showShort(this,getString(strId));
    }

    public void showMessageLong(String msg){
        ToastUtil.showLong(this,msg);
    }

    public void showMessageLong(int strId){
        ToastUtil.showLong(this,getString(strId));
    }

    public void showDialog(String msg){
        if(isMainThread()){
            if (!mProgressDialog.isShowing())
                mProgressDialog.showDialog(msg);
        }else{
            runOnUiThread(() -> {
                if (!mProgressDialog.isShowing())
                    mProgressDialog.showDialog(msg);
                Logger.i("您并不在子线程");
            });
        }
    }

    public void dissMiss(){
        if(isMainThread()){
            if (mProgressDialog.isShowing())
                mProgressDialog.dissmiss();
        }else{
            runOnUiThread(() -> {
                if (mProgressDialog.isShowing())
                    mProgressDialog.dissmiss();
                Logger.i("您并不在子线程");
            });
        }
    }
}
