package com.zjtmanhua.administrator.ui.notificationProxy;

import android.app.Notification;
import android.content.Context;
import android.widget.RemoteViews;

import com.zjtmanhua.administrator.ui.R;

/**
 * 默认通知栏样式
 */

public class NotifyNormal extends  Notify {
    public NotifyNormal(Context context) {
        super(context);
    }

    @Override
    void send() {
        Notification n=builder.build();
        n.contentView=new RemoteViews(context.getPackageName(), R.layout.support_simple_spinner_dropdown_item);
        nm.notify(0,n);
    }

    @Override
    void cancel() {
    nm.cancel(0);
    }
}
