package com.example.gamecomponent.fragment;

import com.example.componentlibs.base.Activitycope;
import com.example.componentlibs.base.LibApplicationComponent;
import com.example.gamecomponent.GameFragment;

import dagger.Component;

/**
 * 作者：ShuWen
 * 日期：2018/7/19. 16:27
 * 描述：
 */
@Activitycope
@Component(dependencies = LibApplicationComponent.class,modules = GameFragmentModule.class)
public interface GameFragmentComponent {
    void inject(GameFragment gameFragment);
}
