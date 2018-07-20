package com.example.administrator.androidcomponent;

import android.app.Application;

import com.example.componentlibs.base.BaseIPlugin;
import com.example.componentlibs.base.Plugins;


/**
 * 作者：ShuWen
 * 日期：2018/7/18. 15:39
 * 描述：
 */
public class AppIplugin extends BaseIPlugin {
    @Override
    public void dependency() {
        dependsOn(Plugins.PLUGIN_UP);
//        dependsOn(Plugins.PLUGIN_GAME);
    }

    @Override
    public void configure() {

    }

    @Override
    public void execute(Application application) {
        if (application instanceof AppApplication) {
            ((AppApplication) application).init(application);
        } else {
            AppApplication myapp = new AppApplication();
            myapp.init(application);
        }
    }

    public static void init(Application application) {
        AppIplugin plugin = new AppIplugin();
        plugin.doInit(application);
    }
}
