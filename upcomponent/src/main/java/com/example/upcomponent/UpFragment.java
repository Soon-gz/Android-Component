package com.example.upcomponent;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.commonbasiclibrary.router.ui.UIRouter;
import com.example.componentservice.UiRouterPathManager;
import com.example.componentservice.bean.BarSerial;
import com.example.componentservice.bean.FooParcel;
import com.example.componentservice.customViews.ToastUtils;


public class UpFragment extends Fragment implements View.OnClickListener {

    private static Bundle bundle = new Bundle();

    private static Bundle bundle2 = new Bundle();

    static {
        bundle.putString("foo", "foo string");
        bundle.putString("EXTRA_STR_BAR", "bar string");

        BarSerial barSerial = new BarSerial();
        barSerial.setBarString("bar string");

        FooParcel fooParcel = new FooParcel();
        fooParcel.setFooInt(2);

        bundle2.putParcelable("foo", fooParcel);
        bundle2.putSerializable("EXTRA_STR_BAR", barSerial);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_up,container,false);
        view.findViewById(R.id.upDemo1).setOnClickListener(this);
        view.findViewById(R.id.upDemo2).setOnClickListener(this);
        view.findViewById(R.id.upDemo3).setOnClickListener(this);
        view.findViewById(R.id.upDemo4).setOnClickListener(this);
        view.findViewById(R.id.upDemo5).setOnClickListener(this);
        view.findViewById(R.id.upDemo6).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.upDemo1) {
            openUri(getContext(), UIRouter.getInstance().getHostPath("gameComponent","Demo1Activity"), null);
        } else if (v.getId() == R.id.upDemo2) {
            openUri(getContext(),UIRouter.getInstance().getHostPath("gameComponent","Demo2Activity"), bundle);
        } else if (v.getId() == R.id.upDemo3) {
            openUri(getContext(),UIRouter.getInstance().getHostPath("gameComponent","Demo3Activity")+"?foo=foo string&EXTRA_STR_BAR=bar string", null);
        } else if (v.getId() == R.id.upDemo4) {
            openUri(getContext(),UiRouterPathManager.Demo4Activity.getGamePath()+"?foo=foo string in url&EXTRA_STR_BAR=bar string in url", bundle);
        } else if (v.getId() == R.id.upDemo5) {
            openUri(getContext(),UiRouterPathManager.Demo5Activity.getGamePath(), bundle2);
        } else if (v.getId() == R.id.upDemo6) {
            openUri(getContext(),UiRouterPathManager.ShareActivity.getSNLPath()+"?shareStr=Up内容的分享", null);
        }
    }

    public void openUri(Context context,String url,Bundle bundle) {
        boolean isSuccess = UIRouter.getInstance().openUri(context,url, bundle);
        if (!isSuccess) {
            ToastUtils.showComponent(getContext(),url);
        }
    }

}
