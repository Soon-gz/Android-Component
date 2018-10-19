package com.example.administrator.androidcomponent;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.commonbasiclibrary.router.ui.UIRouter;
import com.example.componentservice.UiRouterPathManager;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_start);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                UIRouter.getInstance().openUri(StartActivity.this, UiRouterPathManager.appMainActivity.getAppPath(),null);
                finish();
            }
        },1000);
    }
}
