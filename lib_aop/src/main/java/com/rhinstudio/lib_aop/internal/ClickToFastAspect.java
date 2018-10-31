package com.rhinstudio.lib_aop.internal;

import android.util.Log;


import com.rhinstudio.lib_aop.Constant;
import com.rhinstudio.lib_aop.util.ClickUtil;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ClickToFastAspect extends CommonAspect{

    @Around("execution(* android.view.View.OnClickListener.onClick(..)) && onClickToFast()" +
            "|| execution(* android.widget.AdapterView.OnItemClickListener.onItemClick(..)) && onClickToFast()")
    public void onClickListener(ProceedingJoinPoint joinPoint) throws Throwable {
        clickToFast(joinPoint);
    }

    @Pointcut("@within(com.rhinstudio.lib_aop.annotation.ClickToFast)||@annotation(com.rhinstudio.lib_aop.annotation.ClickToFast)")
    public void onClickToFast() {
    }

    private void clickToFast(final ProceedingJoinPoint joinPoint) throws Throwable {
        if (ClickUtil.isEnableStartActivity()) {
            joinPoint.proceed();
            Log.d(asTag(), "normal click!");
        } else {
            Log.d(asTag(), "The clicks are too fast!");
        }
    }

    @Override
    public String asTag() {
        return Constant.LOG + ": " +Constant.CLICK_TO_FAST;
    }
}
