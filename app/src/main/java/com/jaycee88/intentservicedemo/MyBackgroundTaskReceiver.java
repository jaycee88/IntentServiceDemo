package com.jaycee88.intentservicedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * MyBackgroundTaskReceiver
 * Created by jaycee on 2017/6/26.
 */
public class MyBackgroundTaskReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String status = intent.getStringExtra("status");
    }
}
