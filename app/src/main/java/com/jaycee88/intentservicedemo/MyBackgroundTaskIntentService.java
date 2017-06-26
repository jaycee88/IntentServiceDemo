package com.jaycee88.intentservicedemo;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

/**
 * MyIntentService
 * Created by jaycee on 2017/6/26.
 */
public class MyBackgroundTaskIntentService extends IntentService {

    private static final String ACTION_RESULT = "com.jaycee88.intentservicedemo.action.RESULT";

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public MyBackgroundTaskIntentService() {
        super("MyBackgroundTaskIntentService");
    }

    public static void startIntentService(Context context) {
        Intent backgroundTask = new Intent(context, MyBackgroundTaskIntentService.class);
        context.startService(backgroundTask);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String data = intent.getDataString();

        Intent localTask = new Intent(ACTION_RESULT);
        localTask.putExtra("status", "status");
        LocalBroadcastManager.getInstance(this).sendBroadcast(localTask);
    }
}
