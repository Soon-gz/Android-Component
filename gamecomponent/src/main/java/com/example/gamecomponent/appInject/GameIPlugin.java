package com.example.gamecomponent.appInject;

import android.app.Application;

import com.example.componentlibs.base.BaseIPlugin;
import com.example.componentlibs.base.Plugins;

/**
 * 作者：ShuWen
 * 日期：2018/7/19. 16:18
 * 描述：
 */
public class GameIPlugin extends BaseIPlugin {
    @Override
    public void dependency() {
        dependsOn(Plugins.PLUGIN_LIB);
    }

    @Override
    public void configure() {

    }

    @Override
    public void execute(Application application) {
        if (application instanceof GameApplication) {
            ((GameApplication) application).init(application);
        } else {
            GameApplication myapp = new GameApplication();
            myapp.init(application);
        }
    }

    public static void init(Application application) {
        GameIPlugin plugin = new GameIPlugin();
        plugin.doInit(application);
    }
}
