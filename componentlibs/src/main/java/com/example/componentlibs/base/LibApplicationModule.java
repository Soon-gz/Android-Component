package com.example.componentlibs.base;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：ShuWen
 * 日期：2018/7/17. 17:17
 * 描述：
 */
@Module
public class LibApplicationModule {
    Application application;

    public LibApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationScope
    public Application getApplication() {
        return application;
    }
}
