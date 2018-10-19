package com.example.snlcomponent.runalone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.commonbasiclibrary.router.ui.UIRouter;
import com.example.snlcomponent.LoginActivity;
import com.example.snlcomponent.R;
import com.example.snlcomponent.ShareActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIRouter.getInstance().openUri(MainActivity.this, UIRouter.getInstance().getHostPath("snlComponent", ShareActivity.class)+"?shareStr=分享组件化",null);
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIRouter.getInstance().openUri(MainActivity.this, UIRouter.getInstance().getHostPath("snlComponent", LoginActivity.class),null);
            }
        });
    }

}
