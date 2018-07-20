package com.example.gamecomponent;

import javax.inject.Inject;

/**
 * 作者：ShuWen
 * 日期：2018/7/19. 16:28
 * 描述：
 */
public class GameFragmentPresenter {
    @Inject
    public GameFragmentPresenter() {
    }

    public String getString() {
        return "game dagger 成功！";
    }
}
