package com.rhinstudio.lib_aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解添加在方法上，如果需要申请一个及一个以上的权限，必须的
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NeedsPermission {
    String[] value();
    int maxSdkVersion() default 0;
}