package com.example.upcomponent.serviceImpl;


import android.support.v4.app.Fragment;

import com.example.componentservice.upFragmentService.UpFragmentService;
import com.example.upcomponent.UpFragment;

/**
 * 作者：ShuWen
 * 日期：2018/7/15. 14:40
 * 描述：
 */
public class UpFragmentServiceImpl implements UpFragmentService {
    @Override
    public Fragment getUpFragment() {
        return new UpFragment();
    }
}
