package com.example.componentservice.bean;

import java.io.Serializable;

/**
 * @author ShuWen
 * @email shuwen@corp.netease.com
 * @create_date 2018/10/14
 * @description:
 */

public class BarSerial implements Serializable {
    private String barString = "暂不支持使用Serializable";

    public BarSerial() {
    }

    public String getBarString() {
        return barString;
    }

    public void setBarString(String barString) {
//            this.barString = barString;
    }

    @Override
    public String toString() {
        return "BarSerial:{" +
                "barString:" + barString +
                "}";
    }
}
