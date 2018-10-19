package com.example.administrator.androidcomponent;

import com.example.commonbasiclibrary.applicationinject.IApplicationInject;
import com.example.commonbasiclibrary.router.ui.UIRouter;

/**
 * @author ShuWen
 * @email shuwen@corp.netease.com
 * @create_date 2018/10/15
 * @description:
 */

public class AppApplicationInject implements IApplicationInject {
    UIRouter uiRouter = UIRouter.getInstance();

    @Override
    public void onCreate() {
        uiRouter.registerUI("app");
    }

    @Override
    public void onStop() {
        uiRouter.unregisterUI("app");
    }
}
