package com.example.gamecomponent.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.routerannotation.annotation.Autowired;
import com.example.routerannotation.annotation.RouteNode;


@RouteNode(path = "/uirouter/demo/2", desc = "使用bundle传递参数")
public class Demo2Activity extends TestActivity {
    private static Bundle bundle = new Bundle();

    static {
        bundle.putString("foo", "foo string");
        bundle.putString("EXTRA_STR_BAR", "bar string");
    }

    @Autowired() //不指定名称时将使用变量名，若被混淆可能出现问题 建议使用name指定key，参考bar的使用
    String foo;

    @Autowired(name = "EXTRA_STR_BAR")
    String bar;

    @Override
    protected void displayInfo(TextView textView) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("使用bundle传递参数成功\r\n");
        stringBuilder.append("foo:").append(foo).append("\r\n");
        stringBuilder.append("bar:").append(bar).append("\r\n");

        textView.setText(getClass().getName()+"\n"+stringBuilder.toString());
    }
}
