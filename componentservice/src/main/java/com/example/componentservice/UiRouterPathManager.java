package com.example.componentservice;

/**
 * @author ShuWen
 * @email shuwen@corp.netease.com
 * @create_date 2018/10/15
 * @description:
 */

public enum  UiRouterPathManager {

    Demo1Activity("/uirouter/demo/1"),
    Demo2Activity("/uirouter/demo/2"),
    Demo3Activity("/uirouter/demo/3"),
    Demo4Activity("/uirouter/demo/4"),
    Demo5Activity("/uirouter/demo/5"),
    Demo6Activity("/uirouter/demo/6"),
    Demo7Activity("/uirouter/demo/7"),
    Demo8Activity("/uirouter/demo/8"),
    UpActivity("/UpActivity"),
    appMainActivity("/MainActivity"),
    ShareActivity("/ShareActivity"),
    LoginActivity("/LoginActivity");

    private String path;

    UiRouterPathManager(String path) {
        this.path = path;
    }

    public String getAppPath() {
        return "UP://app"+path;
    }

    public String getGamePath() {
        return "UP://gameComponent"+path;
    }

    public String getUpPath() {
        return "UP://upComponent"+path;
    }

    public String getSNLPath() {
        return "UP://snlComponent"+path;
    }
}
