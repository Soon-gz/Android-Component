package com.example.administrator.androidcomponent;// PackageElement

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.administrator.androidcomponent.databinding.AppActivityMainBinding;
import com.example.commonbasiclibrary.router.Router;
import com.example.componentservice.gameComponentService.GameFragmentService;
import com.example.componentservice.meComponentService.MeFragmentService;
import com.example.componentservice.upComponentService.UpFragmentService;
import com.example.routerannotation.annotation.RouteNode;

import java.util.ArrayList;
import java.util.List;

@RouteNode(path = "/MainActivity",desc = "app主页")
public class MainActivity extends AppCompatActivity implements View.OnClickListener { // TypeElement

    AppActivityMainBinding mainBinding;
    public static final int POSITION_UP = 0;// VariableElement
    public static final int POSITION_GAME = 1;// VariableElement
    public static final int POSITION_ME = 2;
    private MainPageAdapter mainPageAdapter;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.app_activity_main);
        fragments = new ArrayList<>();
        fragments.add(getFragment(POSITION_UP,"upComponent"));
        fragments.add(getFragment(POSITION_GAME,"gameComponent"));
        fragments.add(getFragment(POSITION_ME,"meComponent"));
        mainPageAdapter = new MainPageAdapter(getSupportFragmentManager());
        mainBinding.mainContent.setAdapter(mainPageAdapter);
        setListener();
    }

    private void setListener() {
        mainBinding.mainContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == POSITION_UP) {
                    mainBinding.buttonUp.setChecked(true);
                } else if (position == POSITION_GAME) {
                    mainBinding.buttonGame.setChecked(true);
                } else if (position == POSITION_ME) {
                    mainBinding.buttonMe.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        mainBinding.bottomNavi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId == R.id.button_up) {
                    mainBinding.mainContent.setCurrentItem(POSITION_UP);
                } else if (checkedId == R.id.button_game) {
                    mainBinding.mainContent.setCurrentItem(POSITION_GAME);
                } else if (checkedId == R.id.button_me) {
                    mainBinding.mainContent.setCurrentItem(POSITION_ME);
                }
            }
        });

        mainBinding.loadUp.setOnClickListener(this);
        mainBinding.loadGame.setOnClickListener(this);
        mainBinding.loadMe.setOnClickListener(this);
        mainBinding.loadSnl.setOnClickListener(this);
        mainBinding.unLoadUp.setOnClickListener(this);
        mainBinding.unLoadGame.setOnClickListener(this);
        mainBinding.unLoadMe.setOnClickListener(this);
        mainBinding.unLoadSnl.setOnClickListener(this);
    }

    private Fragment getFragment(int position,String name) {
        Fragment fragment = BlankFragment.newInstance(name);
        switch (position) {
            case POSITION_UP:
                UpFragmentService upFragmentService = (UpFragmentService) Router.getInstance().getService(UpFragmentService.class.getSimpleName());
                if (upFragmentService != null) {
                    fragment = upFragmentService.getUpFragment();
                }
                break;
            case POSITION_GAME:
                GameFragmentService gameFragmentService = (GameFragmentService) Router.getInstance().getService(GameFragmentService.class.getSimpleName());
                if (gameFragmentService != null) {
                    fragment = gameFragmentService.getGameFragment("游戏库");
                }
                break;
            case POSITION_ME:
                MeFragmentService meFragmentService = (MeFragmentService) Router.getInstance().getService(MeFragmentService.class.getSimpleName());
                if (meFragmentService != null) {
                    fragment = meFragmentService.getMeFragment();
                }
                break;
        }
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.load_up:
                registerComponent(POSITION_UP,"upComponent","com.example.upcomponent.appInject.UpApplicationInject");
                break;
            case R.id.un_load_up:
                unRegisterComponent(POSITION_UP,"upComponent","com.example.upcomponent.appInject.UpApplicationInject");
                break;
            case R.id.load_game:
                registerComponent(POSITION_GAME,"gameComponent","com.example.gamecomponent.appInject.GameApplicationInject");
                break;
            case R.id.un_load_game:
                unRegisterComponent(POSITION_GAME,"gameComponent","com.example.gamecomponent.appInject.GameApplicationInject");
                break;
            case R.id.load_me:
                registerComponent(POSITION_ME,"meComponent","com.example.mecomponent.application.MeIApplicationInject");
                break;
            case R.id.un_load_me:
                unRegisterComponent(POSITION_ME,"meComponent","com.example.mecomponent.application.MeIApplicationInject");
                break;
            case R.id.load_snl:
                Router.registerComponent("com.example.snlcomponent.appInject.SNLApplicationInject");
                Toast.makeText(this, "成功加载SNL组件", Toast.LENGTH_SHORT).show();
                break;
            case R.id.un_load_snl:
                Router.unregisterComponent("com.example.snlcomponent.appInject.SNLApplicationInject");
                Toast.makeText(this, "成功卸载SNL组件", Toast.LENGTH_SHORT).show();
                break;
        }
        mainPageAdapter.notifyDataSetChanged();
    }

    public void registerComponent(int position,String name,String className) {
        Router.registerComponent(className);
        fragments.remove(position);
        fragments.add(position,getFragment(position,name));
        Toast.makeText(this, "成功加载"+name+"组件", Toast.LENGTH_SHORT).show();
    }

    public void unRegisterComponent(int position,String name,String className) {
        Router.unregisterComponent(className);
        fragments.remove(position);
        fragments.add(position,getFragment(position,name));
        Toast.makeText(this, "成功卸载"+name+"组件", Toast.LENGTH_SHORT).show();
    }


    private  class MainPageAdapter extends FragmentStatePagerAdapter {
        public MainPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return 3;
        }


        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }
}
