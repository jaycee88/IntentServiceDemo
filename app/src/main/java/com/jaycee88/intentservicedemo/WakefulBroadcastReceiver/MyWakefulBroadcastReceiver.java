package com.jaycee88.intentservicedemo.WakefulBroadcastReceiver;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * MyWakefulBroadcastReceiver
 * Created by jaycee on 2017/6/27.
 */
public class MyWakefulBroadcastReceiver extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service = new Intent(context, MyWakefulIntentService.class);
        startWakefulService(context, service);
    }
}
