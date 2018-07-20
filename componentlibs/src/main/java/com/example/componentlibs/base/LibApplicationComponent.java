package com.example.componentlibs.base;

import dagger.Component;

/**
 * 作者：ShuWen
 * 日期：2018/7/17. 17:16
 * 描述：
 */
@ApplicationScope
@Component(modules = LibApplicationModule.class)
public interface LibApplicationComponent {
    void inject(LibApplication application);
}
