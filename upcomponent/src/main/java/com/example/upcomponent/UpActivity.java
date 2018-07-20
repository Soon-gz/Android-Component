package com.example.upcomponent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.commonbasiclibrary.service.AutowiredService;
import com.example.componentlibs.base.LibApplication;
import com.example.componentservice.upFragmentService.UpBean;
import com.example.routerannotation.annotation.Autowired;
import com.example.routerannotation.annotation.RouteNode;

import javax.inject.Inject;

@RouteNode(path = "/UpActivity",desc = "Up主界面")
public class UpActivity extends AppCompatActivity {

    @Inject
    UpActivityPresenter presenter;

    @Autowired(name = "UpName")
    String name;

    @Autowired
    UpBean upBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerUpActivityComponent.builder().libApplicationComponent(LibApplication.getInstance().getApplicationComponent())
                .upActivityModule(new UpActivityModule(this)).build().inject(this);
        setContentView(R.layout.activity_up_activity);
        AutowiredService.Factory.getSingletonImpl().autowire(this);
        TextView textView = findViewById(R.id.upText);
        if (presenter != null) {
            textView.setText(name +" \n " +upBean.name + "\n" + upBean.address +"\n" + presenter.getString());
        } else {
            textView.setText(name +" \n " +upBean.name + "\n" + upBean.address);
        }
    }
}
