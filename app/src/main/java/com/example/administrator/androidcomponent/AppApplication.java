package com.example.administrator.androidcomponent;

import android.app.Application;
import android.util.Log;

import com.example.commonbasiclibrary.router.Router;
import com.example.componentlibs.base.IApplicationInterface;

/**
 * 作者：ShuWen
 * 日期：2018/6/16. 18:50
 * 描述：
 */
public class AppApplication extends Application implements IApplicationInterface {
    @Override
    public void onCreate() {
        super.onCreate();
//        Router.registerComponent("com.example.upcomponent.appInject.UpApplicationInject");
    }

    @Override
    public void init() {
        Log.i("tag00","初始化AppApplication");
    }
}
