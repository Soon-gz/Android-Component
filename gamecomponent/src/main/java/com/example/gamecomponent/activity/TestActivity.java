package com.example.gamecomponent.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.gamecomponent.R;
import com.example.commonbasiclibrary.service.AutowiredService;

public abstract class TestActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        textView = findViewById(R.id.demo_tv_info);
        AutowiredService.Factory.getSingletonImpl().autowire(this);
        displayInfo(textView);
    }

    protected abstract void displayInfo(TextView textView);
}
