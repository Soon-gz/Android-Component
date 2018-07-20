package com.example.administrator.androidcomponent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.commonbasiclibrary.router.Router;
import com.example.componentservice.gameFragmentService.GameFragmentService;
import com.example.componentservice.upFragmentService.UpFragmentService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    Fragment fragment;
    FragmentTransaction ft;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Class aClass = Class.forName("com.example.upcomponent.SingleInstance");
            Method method = aClass.getMethod("isLogin");
            boolean isLogin = (boolean) method.invoke(null);
            if (isLogin) {
                showUpFragment();
            } else {
                showGameFragment();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void showUpFragment() {
        if (fragment != null) {
            ft = getSupportFragmentManager().beginTransaction();
            ft.remove(fragment).commit();
            fragment = null;
        }
        Router router = Router.getInstance();
        if (router.getService(UpFragmentService.class.getSimpleName()) != null) {
            UpFragmentService service = (UpFragmentService) router.getService(UpFragmentService.class.getSimpleName());
            fragment = service.getUpFragment();
            ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, fragment).commitAllowingStateLoss();
        }
    }

    private void showGameFragment() {
        if (fragment != null) {
            ft = getSupportFragmentManager().beginTransaction();
            ft.remove(fragment).commit();
            fragment = null;
        }
        Router router = Router.getInstance();
        if (router.getService(GameFragmentService.class.getSimpleName()) != null) {
            GameFragmentService service = (GameFragmentService) router.getService(GameFragmentService.class.getSimpleName());
            fragment = service.getGameFragment();
            ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, fragment).commitAllowingStateLoss();
        }
    }

}
