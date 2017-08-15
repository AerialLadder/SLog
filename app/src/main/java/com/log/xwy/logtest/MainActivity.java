package com.log.xwy.logtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.log.xwy.mylibrary.TestLib;
import com.xwy.slog.SLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SLog.getUtils().d("onStart");
        SLog.logFlag = true;
        SLog.setTag("123");
    }

    @Override
    protected void onResume() {
        super.onResume();
        SLog.getUtils().d("onResume");
        TestLib.getTestLib();
    }
}
