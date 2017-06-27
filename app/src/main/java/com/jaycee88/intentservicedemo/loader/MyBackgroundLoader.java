package com.jaycee88.intentservicedemo.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;

/**
 * MyBackgroundLoader
 * Created by jaycee on 2017/6/27.
 */
public class MyBackgroundLoader extends AsyncTaskLoader<String> {

    public MyBackgroundLoader(Context context) {
        super(context);
        onContentChanged();
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if (takeContentChanged()) {
            forceLoad();
        }
    }

    @Override
    public String loadInBackground() {
        return "status";
    }
}
