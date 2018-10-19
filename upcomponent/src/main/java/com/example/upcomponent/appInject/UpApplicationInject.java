package com.example.upcomponent.appInject;

import com.example.commonbasiclibrary.applicationinject.IApplicationInject;
import com.example.commonbasiclibrary.router.Router;
import com.example.commonbasiclibrary.router.ui.UIRouter;
import com.example.componentservice.upComponentService.UpFragmentService;
import com.example.upcomponent.serviceImpl.UpFragmentServiceImpl;

/**
 * 作者：ShuWen
 * 日期：2018/7/15. 14:43
 * 描述：
 */
public class UpApplicationInject implements IApplicationInject {
    Router router = Router.getInstance();
    UIRouter uiRouter = UIRouter.getInstance();

    @Override
    public void onCreate() {
        uiRouter.registerUI("upComponent");
        router.addService(UpFragmentService.class.getSimpleName(),new UpFragmentServiceImpl());
    }

    @Override
    public void onStop() {
        uiRouter.unregisterUI("upComponent");
        router.removeService(UpFragmentService.class.getSimpleName());
    }
}
