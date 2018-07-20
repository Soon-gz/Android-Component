package com.example.gamecomponent;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.commonbasiclibrary.router.ui.UIRouter;
import com.example.componentlibs.base.LibApplication;
import com.example.componentservice.upFragmentService.UpBean;
import com.example.gamecomponent.fragment.DaggerGameFragmentComponent;
import com.example.gamecomponent.fragment.GameFragmentModule;
import com.google.gson.Gson;

import javax.inject.Inject;


public class GameFragment extends Fragment {
    @Inject
    GameFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DaggerGameFragmentComponent.builder().libApplicationComponent(LibApplication.getInstance().getApplicationComponent())
                .gameFragmentModule(new GameFragmentModule(this)).build().inject(this);
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        view.findViewById(R.id.game).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UIRouter.getInstance().openUri(getActivity(),"UP://upComponent/UpActivity",null);
            }
        });
        TextView textView = view.findViewById(R.id.game3);
        if (presenter != null) {
            textView.setText(presenter.getString());
        }
        final UpBean upBean = new UpBean();
        upBean.name = "哈哈哈哈";
        upBean.address = "北京四合院";
        view.findViewById(R.id.game2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("upBean",new Gson().toJson(upBean,UpBean.class));
                bundle.putString("UpName","nameFromGameFragment");
                UIRouter.getInstance().openUri(getActivity(),"UP://upComponent/UpActivity",bundle);
            }
        });
        return view;
    }

}
