package com.rhinstudio.lib_aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解添加在方法上，如果用户拒绝了权限的之后执行的方法，可选。
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface OnPermissionDenied {
    String[] value();
}