package com.example.mecomponent.meFragmentService;

import android.support.v4.app.Fragment;

import com.example.componentservice.meComponentService.MeFragmentService;
import com.example.mecomponent.MeFragment;

/**
 * @author ShuWen
 * @email shuwen@corp.netease.com
 * @create_date 2018/10/15
 * @description:
 */

public class MeFragmentServiceImpl implements MeFragmentService {
    @Override
    public Fragment getMeFragment() {
        return MeFragment.newInstance();
    }
}
