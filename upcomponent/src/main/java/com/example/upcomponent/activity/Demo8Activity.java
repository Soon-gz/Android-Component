package com.example.upcomponent.activity;

import android.widget.TextView;

import com.example.routerannotation.annotation.Autowired;
import com.example.routerannotation.annotation.RouteNode;
import com.example.upcomponent.BaseActivity;


@RouteNode(path = "/uirouter/demo/8", desc = "必须参数2")
public class Demo8Activity extends BaseActivity {

    @Autowired(required = true,throwOnNull = true)
    String foo;


    @Override
    protected void displayInfo(TextView textView) {
        textView.setText(getClass().getName()+"\n"+"不使用safemode 将直接crash");
    }
}
