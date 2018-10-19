package com.example.gamecomponent.serviceImpl;

import android.support.v4.app.Fragment;

import com.example.componentservice.gameComponentService.GameFragmentService;
import com.example.gamecomponent.GameFragment;

/**
 * 作者：ShuWen
 * 日期：2018/7/15. 16:55
 * 描述：
 */
public class GameFragmentServiceImpl implements GameFragmentService {
    @Override
    public Fragment getGameFragment(String type) {
        return GameFragment.getInstance(type);
    }
}
