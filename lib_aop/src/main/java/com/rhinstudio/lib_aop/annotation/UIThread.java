package com.rhinstudio.lib_aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解加到方法上，加在 <code>Activity</code> 的方法中，
 *
 * 当前方法会回到UI线程运行。
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface UIThread {
}
