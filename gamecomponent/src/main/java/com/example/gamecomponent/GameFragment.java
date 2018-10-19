package com.example.gamecomponent;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.commonbasiclibrary.router.ui.UIRouter;
import com.example.commonbasiclibrary.router.ui.VerifyResult;
import com.example.componentlibs.base.LibApplication;
import com.example.componentservice.UiRouterPathManager;
import com.example.componentservice.bean.Foo;
import com.example.componentservice.customViews.ToastUtils;
import com.example.componentservice.upComponentService.UpBean;
import com.example.gamecomponent.fragment.DaggerGameFragmentComponent;
import com.example.gamecomponent.fragment.GameFragmentModule;
import com.google.gson.Gson;

import javax.inject.Inject;


public class GameFragment extends Fragment implements View.OnClickListener {
    private static String  TYPE = "type";
    private static Foo test;
    private  Bundle bundle;

    static {
        test = new Foo();
        test.setFooInt(2);
        test.setFooString("foo string");
    }

    String type;
    public static GameFragment getInstance(String type) {
        GameFragment gameFragment = new GameFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TYPE,type);
        gameFragment.setArguments(bundle);
        return gameFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            type = getArguments().getString(TYPE);
        }
    }

    @Inject
    GameFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DaggerGameFragmentComponent.builder().libApplicationComponent(LibApplication.getInstance().getApplicationComponent())
                .gameFragmentModule(new GameFragmentModule(this)).build().inject(this);
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        TextView textViewPresnter = view.findViewById(R.id.game_presenter);
        TextView textViewType= view.findViewById(R.id.type);
        textViewType.setText(type);
        if (presenter != null) {
            textViewPresnter.setText(presenter.getString());
        }
        bundle = new Bundle();
        bundle.putString("UpName","从游戏组件携带的name");
        UpBean upBean = new UpBean();
        upBean.address = "游戏库";
        upBean.name = "携带的bean对象参数";
        bundle.putParcelable("upBean",upBean);
        view.findViewById(R.id.upDemo6).setOnClickListener(this);
        view.findViewById(R.id.upDemo7).setOnClickListener(this);
        view.findViewById(R.id.upDemo8).setOnClickListener(this);
        view.findViewById(R.id.upDemo9).setOnClickListener(this);
        view.findViewById(R.id.upDemo10).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.upDemo6) {
            openUri(getContext(), UIRouter.getInstance().getHostPath("upComponent","Demo6Activity") + "?EXTRA_OBJ_FOO=" + new Gson().toJson(test),null);
        } else if (v.getId() == R.id.upDemo7) {
            UIRouter.getInstance().openUri(getContext(),UIRouter.getInstance().getHostPath("upComponent","Demo7Activity"), null);
        } else if (v.getId() == R.id.upDemo8) {
            navigateUseSafeMode(UIRouter.getInstance().getHostPath("upComponent","Demo8Activity"),null);
        } else if (v.getId() == R.id.upDemo9) {
            openUri(getContext(),UIRouter.getInstance().getHostPath("upComponent","UpActivity"),bundle);
        } else if (v.getId() == R.id.upDemo10) {
            openUri(getContext(),UiRouterPathManager.ShareActivity.getSNLPath()+"?shareStr=游戏库分享",null);
        }
    }

    public void openUri(Context context, String url, Bundle bundle) {
        boolean isSuccess = UIRouter.getInstance().openUri(context,url, bundle);
        if (!isSuccess) {
            ToastUtils.showComponent(getContext(),url);
        }
    }

    private void navigateUseSafeMode(String url,Bundle bundle) {
        //对于外部唤醒等场景，需要对url，参数做一定的校验，以确保程序的稳定运行
        //注意：对于稳定可靠的业务，可以不使用这种校验。
        VerifyResult result = UIRouter.getInstance().verifyUri(Uri.parse(url), bundle, true);

        if (result.isSuccess()) {
            UIRouter.getInstance().openUri(getContext(), url, bundle);
        } else {
            Log.e("UP","安全模式发现异常："+result.getThrowable().getMessage());

            /*可以在此处进行统计收集或者开发阶段控制台打印错误信息*/
            result.getThrowable().printStackTrace();
        }
    }
}
