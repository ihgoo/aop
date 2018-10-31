package com.rhinstudio.lib_aop.annotation;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解可加到匿名内部类方法上
 * android.view.View.OnClickListener.onClick 或 android.widget.AdapterView.OnItemClickListener.onItemClick
 * 防止短时间内重复点击多次
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface ClickToFast {
}
