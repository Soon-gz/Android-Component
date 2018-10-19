package com.example.gamecomponent.appInject;

import com.example.commonbasiclibrary.applicationinject.IApplicationInject;
import com.example.commonbasiclibrary.router.Router;
import com.example.commonbasiclibrary.router.ui.UIRouter;
import com.example.componentservice.gameComponentService.GameFragmentService;
import com.example.gamecomponent.serviceImpl.GameFragmentServiceImpl;

/**
 * 作者：ShuWen
 * 日期：2018/7/15. 16:56
 * 描述：
 */
public class GameApplicationInject implements IApplicationInject{
    Router router = Router.getInstance();
    UIRouter uiRouter = UIRouter.getInstance();
    @Override
    public void onCreate() {
        uiRouter.registerUI("gameComponent");
        router.addService(GameFragmentService.class.getSimpleName(),new GameFragmentServiceImpl());
    }

    @Override
    public void onStop() {
        uiRouter.unregisterUI("gameComponent");
        router.removeService(GameFragmentService.class.getSimpleName());
    }
}
