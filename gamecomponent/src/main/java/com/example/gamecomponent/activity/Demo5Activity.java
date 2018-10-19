package com.example.gamecomponent.activity;

import android.widget.TextView;

import com.example.componentservice.bean.BarSerial;
import com.example.componentservice.bean.FooParcel;
import com.example.routerannotation.annotation.Autowired;
import com.example.routerannotation.annotation.RouteNode;

@RouteNode(path = "/uirouter/demo/5", desc = "Parcelable和Serializable")
public class Demo5Activity extends TestActivity {

    @Autowired()
    FooParcel foo;

//    @Autowired(name = "EXTRA_STR_BAR")
    BarSerial bar = new BarSerial();


    @Override
    protected void displayInfo(TextView textView) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("使用bundle传递参数成功\r\n");
        stringBuilder.append("foo:").append(foo.toString()).append("\r\n");
        stringBuilder.append("bar:").append(bar.toString()).append("\r\n");

        textView.setText(getClass().getName()+"\n"+stringBuilder.toString());
    }




}
