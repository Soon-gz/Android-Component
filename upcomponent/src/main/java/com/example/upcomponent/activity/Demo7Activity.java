package com.example.upcomponent.activity;

import android.widget.TextView;

import com.example.routerannotation.annotation.Autowired;
import com.example.routerannotation.annotation.RouteNode;
import com.example.upcomponent.BaseActivity;


@RouteNode(path = "/uirouter/demo/7", desc = "必须参数")
public class Demo7Activity extends BaseActivity {

    @Autowired(required = true)
    String foo;

    @Override
    protected void displayInfo(TextView textView) {
        textView.setText(getClass().getName()+"\n"+"此处Autowired没有使用异常抛出功能，\r\n" +
                "通过安全模式可以捕获ParamException\r\n" +
                "直接跳转，控制台输出错误日志，通过AutowiredProcessor 进行过滤\r\n" +
                "显然，通过异常抛出更容易发现问题");

    }
}
