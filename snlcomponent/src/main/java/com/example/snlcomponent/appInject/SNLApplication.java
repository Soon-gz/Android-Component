package com.example.snlcomponent.appInject;

import android.app.Application;
import android.util.Log;

import com.example.componentlibs.base.IApplicationInterface;

/**
 * @author ShuWen
 * @email shuwen@corp.netease.com
 * @create_date 2018/10/15
 * @description:
 */

public class SNLApplication extends Application implements IApplicationInterface {


    @Override
    public void init() {
        Log.i("tag00","SNLApplication初始化");
    }
}
