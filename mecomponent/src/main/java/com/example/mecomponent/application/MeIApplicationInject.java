package com.example.mecomponent.application;

import com.example.commonbasiclibrary.applicationinject.IApplicationInject;
import com.example.commonbasiclibrary.router.Router;
import com.example.componentservice.meComponentService.MeFragmentService;
import com.example.mecomponent.meFragmentService.MeFragmentServiceImpl;

/**
 * @author ShuWen
 * @email shuwen@corp.netease.com
 * @create_date 2018/10/15
 * @description:
 */

public class MeIApplicationInject implements IApplicationInject {
    Router router = Router.getInstance();

    @Override
    public void onCreate() {
        router.addService(MeFragmentService.class.getSimpleName(),new MeFragmentServiceImpl());
    }

    @Override
    public void onStop() {
        router.removeService(MeFragmentService.class.getSimpleName());
    }
}
