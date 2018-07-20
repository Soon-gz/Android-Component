package com.example.componentlibs.base;

import android.app.Activity;

import dagger.Component;

/**
 * 作者：ShuWen
 * 日期：2018/7/18. 15:20
 * 描述：
 */
@Activitycope
@Component(dependencies = LibApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(Activity activity);
}
