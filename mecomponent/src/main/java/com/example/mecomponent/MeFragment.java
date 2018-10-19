package com.example.mecomponent;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.commonbasiclibrary.router.ui.UIRouter;
import com.example.commonbasiclibrary.router.ui.VerifyResult;
import com.example.componentservice.UiRouterPathManager;
import com.example.componentservice.customViews.ToastUtils;


public class MeFragment extends Fragment {

    public MeFragment() {
    }

    public static MeFragment newInstance() {
        MeFragment fragment = new MeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        view.findViewById(R.id.ivHeadPic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VerifyResult result = UIRouter.getInstance().verifyUri(Uri.parse(UiRouterPathManager.LoginActivity.getSNLPath()),null,false);
                if (result.isSuccess()) {
                    UIRouter.getInstance().openUri(getContext(),UiRouterPathManager.LoginActivity.getSNLPath(),null);
                } else {
                    ToastUtils.showComponent(getContext(),UiRouterPathManager.LoginActivity.getSNLPath());
                }
            }
        });
        return view;
    }

}
