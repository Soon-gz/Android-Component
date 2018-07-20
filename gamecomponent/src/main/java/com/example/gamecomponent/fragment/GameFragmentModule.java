package com.example.gamecomponent.fragment;

import com.example.componentlibs.base.Activitycope;
import com.example.gamecomponent.GameFragment;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：ShuWen
 * 日期：2018/7/19. 16:27
 * 描述：
 */
@Module
public class GameFragmentModule {
    GameFragment gameFragment;

    public GameFragmentModule(GameFragment gameFragment) {
        this.gameFragment = gameFragment;
    }

    @Provides
    @Activitycope
    GameFragment getGameFragment() {
        return gameFragment;
    }
}
