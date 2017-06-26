package com.jaycee88.intentservicedemo;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MyBackgroundTaskReceiver localReceiver;

    private static final String ACTION_RESULT = "com.jaycee88.intentservicedemo.action.RESULT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter(ACTION_RESULT);
        localReceiver = new MyBackgroundTaskReceiver();
        LocalBroadcastManager.getInstance(this).registerReceiver(localReceiver, intentFilter);

//        MyBackgroundTaskIntentService.startIntentService(this);
        ForeService.startService(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(localReceiver);
    }
}
