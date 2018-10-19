package com.example.administrator.androidcomponent;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BlankFragment extends Fragment {
    private static String NAME = "name";

    TextView textView;
    String name;

    public BlankFragment() {
    }

    public static BlankFragment newInstance(String name) {
        BlankFragment fragment = new BlankFragment();
        Bundle bundle = new Bundle();
        bundle.putString(NAME,name);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.app_fragment_blank, container, false);
        textView = view.findViewById(R.id.empty_text);
        textView.setText("未加载组件："+name);
        return view;
    }

}
