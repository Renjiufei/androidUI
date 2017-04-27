package com.zjtmanhua.administrator.ui.notificationProxy;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Administrator on 2017/4/24.
 */

public abstract class Notify {
    protected Context context;
    protected NotificationManager nm;
    NotificationCompat.Builder builder;

    public Notify(Context context) {
        this.context = context;
        nm=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        builder=new NotificationCompat.Builder(context);
//        builder.setSmallIcon(R.drawable.ic_launcher).setContentIntent(PendingIntent.getActivity(context,0,new Intent(context,ResultActivity.class,PendingIntent.FLAG_UPDATE_CURRENT));




    }

    abstract  void send();
    abstract  void cancel();






}
