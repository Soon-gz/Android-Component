package com.example.gamecomponent.runalone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.gamecomponent.GameFragment;
import com.example.runalone.game.R;


public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.game_container, GameFragment.getInstance("Game单独调试，游戏库")).commit();
    }

}
