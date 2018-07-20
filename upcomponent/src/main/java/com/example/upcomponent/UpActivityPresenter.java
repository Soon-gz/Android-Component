package com.example.upcomponent;

import javax.inject.Inject;

/**
 * 作者：ShuWen
 * 日期：2018/7/18. 15:33
 * 描述：
 */
public class UpActivityPresenter {
    @Inject
    public UpActivityPresenter() {
    }

    public String getString() {
        return "dagger注入成功！";
    }
}
