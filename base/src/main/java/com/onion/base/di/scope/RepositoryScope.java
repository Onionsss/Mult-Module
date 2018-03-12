package com.onion.base.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;
import javax.inject.Singleton;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by OnionMac on 2018/3/7.
 */

@Scope
@Singleton
@Retention(RUNTIME)
public @interface RepositoryScope {

}