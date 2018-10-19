package com.example.componentlibs.base;

import android.app.Application;

/**
 * 作者：ShuWen
 * 日期：2018/7/18. 15:24
 * 描述：
 */
@Deprecated
public class LibIPlugin extends BaseIPlugin {
    @Override
    public void dependency() {

    }

    @Override
    public void configure() {

    }

    @Override
    public void execute(Application application) {
        if (application instanceof LibApplication) {
            ((LibApplication) application).init();
        } else {
            LibApplication myapp = new LibApplication();
            myapp.init();
        }
    }

    public static void init(Application application) {
        LibIPlugin serviceIPlugin = new LibIPlugin();
        serviceIPlugin.doInit(application);
    }

}
