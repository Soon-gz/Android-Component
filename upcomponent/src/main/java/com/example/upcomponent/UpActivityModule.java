package com.example.upcomponent;

import android.app.Activity;

import com.example.componentlibs.base.Activitycope;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：ShuWen
 * 日期：2018/7/19. 15:05
 * 描述：
 */
@Module
public class UpActivityModule  {
    Activity upActivity;

    public UpActivityModule(UpActivity upActivity) {
        this.upActivity = upActivity;
    }

    @Provides
    @Activitycope
    Activity getUpActivity () {
        return upActivity;
    }
}
