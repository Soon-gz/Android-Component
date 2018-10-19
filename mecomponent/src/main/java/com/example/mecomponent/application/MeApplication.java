package com.example.mecomponent.application;

import android.app.Application;
import android.util.Log;

import com.example.componentlibs.base.IApplicationInterface;

/**
 * @author ShuWen
 * @email shuwen@corp.netease.com
 * @create_date 2018/10/15
 * @description:
 */

public class MeApplication extends Application implements IApplicationInterface {
    @Override
    public void onCreate() {
        super.onCreate();
        MeIPlugin.init(this);
    }

    @Override
    public void init() {
        Log.i("tag00","MeApplication初始化完成");
    }
}
