package com.example.upcomponent;

import com.example.componentlibs.base.Activitycope;
import com.example.componentlibs.base.LibApplicationComponent;

import dagger.Component;

/**
 * 作者：ShuWen
 * 日期：2018/7/19. 15:09
 * 描述：
 */
@Activitycope
@Component(dependencies = LibApplicationComponent.class,modules = UpActivityModule.class)
public interface UpActivityComponent {
    void inject(UpActivity upActivity);
}
