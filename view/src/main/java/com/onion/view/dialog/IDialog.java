package com.onion.view.dialog;

import android.content.DialogInterface;

/**
 * Created by OnionMac on 2018/3/6.
 * IDialog接口 dialog必须实现该类
 */

public interface IDialog {

    void showDialog(String msg);

    void dissmiss();

    boolean isShowing();

    void setOnCancelListener(DialogInterface.OnCancelListener listener);
}
