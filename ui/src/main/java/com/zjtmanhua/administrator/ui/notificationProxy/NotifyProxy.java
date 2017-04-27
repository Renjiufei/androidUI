package com.zjtmanhua.administrator.ui.notificationProxy;

import android.content.Context;
import android.os.Build;

/**
 * Created by Administrator on 2017/4/24.
 * 使用时
 * new NotifyProxy(context).send();
 *
 *
 */

public class NotifyProxy extends Notify {
    private  Notify notify;
    public NotifyProxy(Context context, Class Class) {
        super(context);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            notify=new NotifyHeadsUp(context);
        }else if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            notify=new NotifyBig(context);
        }else {
            notify=new NotifyNormal(context);
        }






    }

    @Override
    void send() {

    }

    @Override
    void cancel() {

    }
}
