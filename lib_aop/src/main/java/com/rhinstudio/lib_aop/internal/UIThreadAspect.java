package com.rhinstudio.lib_aop.internal;

import android.app.Activity;

import com.rhinstudio.lib_aop.Constant;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class UIThreadAspect extends CommonAspect {

    @Override
    String asTag() {
        return Constant.LOG + ": " + Constant.UIThread;
    }

    @Pointcut("@within(com.rhinstudio.lib_aop.annotation.UIThread)||@annotation(com.rhinstudio.lib_aop.annotation.UIThread)")
    public void runOnUITread(final ProceedingJoinPoint joinPoint) throws Throwable {
        Object target = joinPoint.getTarget();
        if (target instanceof Activity) {
            ((Activity) target).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        joinPoint.proceed();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            });
        }
    }



}
