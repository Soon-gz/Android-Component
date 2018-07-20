package com.example.componentlibs.base;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：ShuWen
 * 日期：2018/7/18. 15:21
 * 描述：
 */
@Module
public class ActivityModule {
    public Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @Activitycope
    public Activity getActivity() {
        return activity;
    }
}
