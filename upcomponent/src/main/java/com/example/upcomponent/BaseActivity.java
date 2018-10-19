package com.example.upcomponent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.commonbasiclibrary.service.AutowiredService;

public class BaseActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        textView = findViewById(R.id.demo_tv_info);
        AutowiredService.Factory.getSingletonImpl()
                .autowire(this);
        displayInfo(textView);
    }

    protected void displayInfo(TextView textView) {

    }
}
