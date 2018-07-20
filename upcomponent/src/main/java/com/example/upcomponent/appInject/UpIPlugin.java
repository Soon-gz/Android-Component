package com.example.upcomponent.appInject;

import android.app.Application;

import com.example.componentlibs.base.BaseIPlugin;
import com.example.componentlibs.base.Plugins;


/**
 * 作者：ShuWen
 * 日期：2018/7/18. 15:09
 * 描述：
 */
public class UpIPlugin extends BaseIPlugin {
    @Override
    public void dependency() {
        dependsOn(Plugins.PLUGIN_LIB);
    }

    @Override
    public void configure() {

    }

    @Override
    public void execute(Application application) {
        if (application instanceof UpApplication) {
            ((UpApplication) application).init(application);
        } else {
            UpApplication myapp = new UpApplication();
            myapp.init(application);
        }
    }

    public static void init(Application application) {
        UpIPlugin plugin = new UpIPlugin();
        plugin.doInit(application);
    }
}
