package com.onion.message;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.onion.base.arouter.HelloService;

/**
 * Created by OnionMac on 2018/2/28.
 */
@Route(path = "/s/s")
public class HelloServiceImpl implements HelloService {

    private Context mContext;
    @Override
    public String sayHello(String name) {
        Toast.makeText(mContext, "Hello " + name, Toast.LENGTH_SHORT).show();
        return null;
    }

    @Override
    public void init(Context context) {
        mContext = context;
    }
}
