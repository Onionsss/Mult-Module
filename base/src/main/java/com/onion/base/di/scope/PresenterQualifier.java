package com.onion.base.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by OnionMac on 2018/3/6.
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PresenterQualifier {
    String value() default "";
}
