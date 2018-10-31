package com.rhinstudio.lib_aop.internal;

import android.nfc.Tag;
import android.util.Log;

import com.rhinstudio.aop.ClickUtil;
import com.rhinstudio.aop.Constant;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Aspect
public class ClickToFastAspect {

    @Around("execution(* android.view.View.OnClickListener.onClick(..)) && onClickToFast()" +
            "|| execution(* android.widget.AdapterView.OnItemClickListener.onItemClick(..)) && onClickToFast()")
    public void onClickListener(ProceedingJoinPoint joinPoint) throws Throwable {
        clickToFast(joinPoint);
    }

    @Pointcut("@within(com.rhinstudio.aop.annotation.ClickToFast)||@annotation(com.rhinstudio.aop.annotation.ClickToFast)")
    public void onClickToFast() {
    }

    private void clickToFast(final ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        if (ClickUtil.isEnableStartActivity()) {
            joinPoint.proceed();
            Log.d(Constant.LOG, "normal click!");
        } else {
            Log.d(Constant.LOG, "The clicks are too fast!");
        }
    }

}
