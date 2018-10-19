package com.example.mecomponent.runalone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mecomponent.MeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new MeFragment()).commit();
    }
}
