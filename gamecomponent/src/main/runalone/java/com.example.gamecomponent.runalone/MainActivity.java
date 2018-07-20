package com.example.gamecomponent.runalone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gamecomponent.GameFragment;
import com.example.runalone.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.game_container,new GameFragment()).commitAllowingStateLoss();

    }
}
