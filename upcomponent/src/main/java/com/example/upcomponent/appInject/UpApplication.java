package com.example.upcomponent.appInject;

import android.app.Application;
import android.util.Log;

import com.example.componentlibs.base.IApplicationInterface;


/**
 * 作者：ShuWen
 * 日期：2018/7/18. 14:49
 * 描述：
 */
public class UpApplication extends Application implements IApplicationInterface {

    @Override
    public void onCreate() {
        super.onCreate();
        UpIPlugin.init(this);
    }

    @Override
    public void init(Application application) {
        Log.i("tag00","初始化upApplication");
    }
}
