package com.jaycee88.intentservicedemo;

import android.app.LoaderManager;
import android.content.IntentFilter;
import android.content.Loader;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

import com.jaycee88.intentservicedemo.loader.MyBackgroundLoader;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

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
        initLoader();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(localReceiver);
    }

    public void initLoader() {
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        return new MyBackgroundLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        String result = data;
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }
}
