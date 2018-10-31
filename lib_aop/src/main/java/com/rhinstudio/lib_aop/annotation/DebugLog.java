package com.rhinstudio.lib_aop.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * 注解加到方法或构造方法上，只在BuildConfig.DEBUG为true时执行。
 * 能输出入参出参，以及方法执行的时间数。
 */
@Target({TYPE, METHOD, CONSTRUCTOR}) @Retention(CLASS)
public @interface DebugLog {
}