package com.example.upcomponent.activity;

import android.util.Log;
import android.widget.TextView;

import com.example.componentservice.bean.Foo;
import com.example.routerannotation.annotation.Autowired;
import com.example.routerannotation.annotation.RouteNode;
import com.example.upcomponent.BaseActivity;


@RouteNode(path = "/uirouter/demo/6", desc = "使用json字符串传参")
public class Demo6Activity extends BaseActivity {

    @Autowired(name = "EXTRA_OBJ_FOO")
    Foo foo;
    private static Foo test;

    static {
        test = new Foo();
        test.setFooInt(2);
        test.setFooString("foo string");
    }


    @Override
    protected void displayInfo(TextView textView) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("使用json字符串传参成功\r\n");
        stringBuilder.append("foo:").append(foo).append("\r\n");
        Log.i("tag00",stringBuilder.toString());
        textView.setText(getClass().getName()+"\n"+stringBuilder.toString());
    }

}
