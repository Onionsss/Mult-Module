package com.onion.base.arouter;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by OnionMac on 2018/2/28.
 */

public interface HelloService extends IProvider {

    String sayHello(String name);

}
