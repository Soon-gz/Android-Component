package com.example.componentlibs.base;

import android.app.Application;

/**
 * Created by hzwuwenchao on 2017/11/7.
 */

public interface IPluginInterface {
    void dependency();
    void configure();
    void execute(Application application);
}
