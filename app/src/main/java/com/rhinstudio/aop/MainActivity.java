package com.rhinstudio.aop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.rhinstudio.lib_aop.annotation.ClickToFast;
import com.rhinstudio.lib_aop.annotation.DebugLog;
import com.rhinstudio.lib_aop.annotation.UIThread;

public class MainActivity extends AppCompatActivity {


    private Button mClickToFastBtn;
    private Button mDebugLogBtn;
    private Button mRunOnUIThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mClickToFastBtn = findViewById(R.id.btn_click_to_fast);
        mDebugLogBtn = findViewById(R.id.btn_debug_log);
        mRunOnUIThread = findViewById(R.id.btn_run_on_ui_thread);
        mClickToFastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            @ClickToFast
            public void onClick(View v) {

            }
        });


        mDebugLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testDebugLog(1, 2, 3, 4);
            }
        });




        mRunOnUIThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    @DebugLog
                    public void run() {
//                        Log.v("MainActivity","thread is " + )
                        testRunOnUIThread();
                    }
                }).start();
            }
        });

    }


    @UIThread
    @DebugLog
    private void testRunOnUIThread(){
        Log.v("MainActivity","hi");
    }


    @DebugLog
    private int testDebugLog(int i, int i1, int i2, int i3) {
        return i + i1 + i2 + i3;
    }


}
