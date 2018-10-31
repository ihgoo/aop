package com.rhinstudio.lib_aop;


import android.os.Handler;

public class ClickUtil {

    public static boolean isDoubleClick = false;

    public static boolean isEnableStartActivity() {
        if (isDoubleClick) {
            return false;
        }
        isDoubleClick = true;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                isDoubleClick = false;
            }
        }, 200);
        return true;
    }
}
