package com.example.runalone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.upcomponent.UpFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.game_container,new UpFragment()).commitAllowingStateLoss();
    }

}
