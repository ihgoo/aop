package com.rhinstudio.lib_aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解添加在方法上，注册在 <code>Activity</code> 或 <code>Fragment</code> 去处理权限，必须的
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface RuntimePermissions {
}