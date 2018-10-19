package com.example.gamecomponent.appInject;

import android.app.Application;
import android.util.Log;

import com.example.componentlibs.base.IApplicationInterface;

/**
 * 作者：ShuWen
 * 日期：2018/7/18. 17:26
 * 描述：
 */
public class GameApplication extends Application implements IApplicationInterface{

    @Override
    public void init() {
        Log.i("tag00","初始化GameApplication");
    }
}
