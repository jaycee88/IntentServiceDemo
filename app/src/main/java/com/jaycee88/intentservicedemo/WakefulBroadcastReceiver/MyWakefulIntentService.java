package com.jaycee88.intentservicedemo.WakefulBroadcastReceiver;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * MyWakefulIntentService
 * Created by jaycee on 2017/6/27.
 */
public class MyWakefulIntentService extends IntentService {

    public MyWakefulIntentService() {
        super("MyWakefulIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        // Background Task
        // 在后台IntentService中，完成Task后，只需要使用MyWakefulBroadcastReceiver.completeWakefulIntent来结束这个任务，即可释放WakeLock。
        MyWakefulBroadcastReceiver.completeWakefulIntent(intent);
    }
}
