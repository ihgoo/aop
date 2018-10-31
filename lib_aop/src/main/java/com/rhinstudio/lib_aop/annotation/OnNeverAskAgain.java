package com.rhinstudio.lib_aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解添加在方法上，如果用户选择永不询问权限，注释一个方法来处理它。可选。
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface OnNeverAskAgain {
    String[] value();
}