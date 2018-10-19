package com.example.gamecomponent.activity;

import android.widget.TextView;

import com.example.routerannotation.annotation.RouteNode;


@RouteNode(path = "/uirouter/demo/1", desc = "无参数")
public class Demo1Activity extends TestActivity {

    @Override
    protected void displayInfo(TextView textView) {
        textView.setText(getClass().getName()+"\n无参数跳转成功");
    }
}
