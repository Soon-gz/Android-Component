package com.example.componentlibs.base;

import android.app.Application;
import android.util.Log;

/**
 * 作者：ShuWen
 * 日期：2018/7/5. 10:04
 * 描述：
 */
public class LibApplication extends Application implements IApplicationInterface{
    private static LibApplication mApplication;
    private static Application mRealApplication;
    private LibApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        LibIPlugin.init(this);
    }

    public static LibApplication getInstance() {
        return mApplication;
    }

    @Override
    public void init(Application application) {
        mApplication = this;
        Log.i("tag00","初始化ServiceApplication");
        applicationComponent = DaggerLibApplicationComponent.create();
        applicationComponent.inject(this);
    }

    public LibApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
