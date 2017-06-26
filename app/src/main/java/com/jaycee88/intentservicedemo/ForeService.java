package com.jaycee88.intentservicedemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.TaskStackBuilder;

/**
 * 前台服务
 * Created by jaycee on 2017/6/26.
 */
public class ForeService extends Service {

    public static void startService(Context context) {
        Intent intent = new Intent(context, ForeService.class);
        context.startService(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onCreate() {
        super.onCreate();
        beginForeService();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void beginForeService() {
        // 创建通知
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("2017-6-26")
                .setContentText("您有一条未读短信...")
                .setAutoCancel(true);

        // 创建带进度条的通知的步骤：
        // 设置进度条：
        // 第一个参数为最大值，
        // 第二个参数为当前进度，
        // 第三个参数表示不确定性，如果为true，则进度不确定，会显示动画，
        // 如果为false，就按照我们设定的进度显示，不会显示
//        builder.setProgress(100, 50, true);
//        builder.setOngoing(true); // 设置是否为进行中的通知，为 true 时不可清除，为 false 时可以清除

        // 创建点击跳转的intent（这个跳转是跳转到通知详情页）
        Intent intent = new Intent(this, NotificationShowActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // 添加指定Activity的父Activity到栈中
        stackBuilder.addParentStack(NotificationShowActivity.class);
        stackBuilder.addNextIntent(intent);

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        // 设置跳转intent到通知中
        builder.setContentIntent(pendingIntent);

        // 获取通知管理器
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // 构建通知
        Notification notification = builder.build();
        // 显示通知
        nm.notify(0, notification);

        startForeground(0, notification);
    }
}
