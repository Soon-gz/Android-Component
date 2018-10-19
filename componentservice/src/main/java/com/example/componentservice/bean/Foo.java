package com.example.componentservice.bean;

/**
 * @author ShuWen
 * @email shuwen@corp.netease.com
 * @create_date 2018/10/14
 * @description:
 */

public class Foo {
    private int fooInt;
    private String fooString;

    public int getFooInt() {
        return fooInt;
    }

    public void setFooInt(int fooInt) {
        this.fooInt = fooInt;
    }

    public String getFooString() {
        return fooString;
    }

    public void setFooString(String fooString) {
        this.fooString = fooString;
    }

    @Override
    public String toString() {
        return "Foo:{" +
                "fooInt:" + fooInt + ","
                + "fooString:" + fooString +
                "}";
    }
}
