package com.example.mecomponent.application;

import android.app.Application;

import com.example.componentlibs.base.BaseIPlugin;
import com.example.componentlibs.base.Plugins;

/**
 * @author ShuWen
 * @email shuwen@corp.netease.com
 * @create_date 2018/10/15
 * @description:
 */

public class MeIPlugin extends BaseIPlugin {
    @Override
    public void dependency() {
        dependsOn(Plugins.PLUGIN_LIB);
    }

    @Override
    public void configure() {

    }

    @Override
    public void execute(Application application) {
        if (application instanceof MeApplication) {
            ((MeApplication) application).init();
        } else {
            MeApplication myapp = new MeApplication();
            myapp.init();
        }
    }

    public static void init(Application application) {
        MeIPlugin plugin = new MeIPlugin();
        plugin.doInit(application);
    }

}
