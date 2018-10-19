package com.example.gamecomponent.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.routerannotation.annotation.Autowired;
import com.example.routerannotation.annotation.RouteNode;


@RouteNode(path = "/uirouter/demo/4", desc = "Url和Bundle同时包含参数")
public class Demo4Activity extends TestActivity {
    private static Bundle bundle = new Bundle();

    static {
        bundle.putString("foo", "foo string in bundle");
        bundle.putString("EXTRA_STR_BAR", "bar string in bundle");
    }

    @Autowired()
    String foo;

    @Autowired(name = "EXTRA_STR_BAR")
    String bar;


    @Override
    protected void displayInfo(TextView textView) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Url和Bundle同时包含参数,以url为准\r\n");
        stringBuilder.append("foo:").append(foo).append("\r\n");
        stringBuilder.append("bar:").append(bar).append("\r\n");

        textView.setText(getClass().getName()+"\n"+stringBuilder.toString());
    }
}
