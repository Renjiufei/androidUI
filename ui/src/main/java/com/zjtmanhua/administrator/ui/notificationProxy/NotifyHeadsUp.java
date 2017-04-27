package com.zjtmanhua.administrator.ui.notificationProxy;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.widget.RemoteViews;

import com.zjtmanhua.administrator.ui.R;

/**
 * Created by Administrator on 2017/4/24.
 */

public class NotifyHeadsUp extends Notify {
    public NotifyHeadsUp(Context context, Class Class) {
        super(context);
    }

    public NotifyHeadsUp(Context context) {
        super(context);
    }

    @TargetApi(21)
    @Override
    void send() {
        Notification n=builder.build();
        n.contentView=new RemoteViews(context.getPackageName(), R.layout.support_simple_spinner_dropdown_item);
        n.bigContentView=new RemoteViews(context.getPackageName(),R.layout.support_simple_spinner_dropdown_item);
        n.headsUpContentView=new RemoteViews(context.getPackageName(),R.layout.support_simple_spinner_dropdown_item);
        nm.notify(0,n);
    }

    @Override
    void cancel() {
    nm.cancel(0);
    }
}
