package com.example.componentservice.customViews;

import android.content.Context;
import android.widget.Toast;

/**
 * @author ShuWen
 * @email shuwen@corp.netease.com
 * @create_date 2018/10/15
 * @description:
 */

public class ToastUtils {
    public static void showComponent(Context context,String url) {
        String msg = null;
        if (url.contains("upComponent")) {
            msg = "请添加UP组件";
        } else if (url.contains("gameComponent")) {
            msg = "请添加GAME组件";
        } else if (url.contains("meComponent")) {
            msg = "请添加ME组件";
        }  else if (url.contains("snlComponent")) {
            msg = "请添加SNL组件";
        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
