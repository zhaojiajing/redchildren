package com.bwie.redchildren.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.bwie.redchildren.R;
import com.bwie.redchildren.fragment.ClassFragment;
import com.bwie.redchildren.fragment.HomeFragment;
import com.bwie.redchildren.fragment.MyebuyFragment;
import com.bwie.redchildren.fragment.ShoppingFragment;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import butterknife.Bind;
import bwie.mylibrary.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {



    @Bind(R.id.fl)
    FrameLayout fl;
    @Bind(R.id.rg)
    RadioGroup rg;
    @Bind(R.id.rb_home)
    RadioButton rbHome;
    @Bind(R.id.rb_classs)
    RadioButton rbClasss;
    @Bind(R.id.rb_shopping)
    RadioButton rbShopping;
    @Bind(R.id.rb_myebuy)
    RadioButton rbMyebuy;


    @Override
    public int bindlayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        addfragment(R.id.fl,new HomeFragment());
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            /**
             *  i即checkedId*******
             */
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_home:
                        //调自己封装的
                   replacefragment(R.id.fl,new HomeFragment());
                        break;
                    case R.id.rb_classs:
                        replacefragment(R.id.fl,new ClassFragment());
                        break;
                    case R.id.rb_shopping:
                        replacefragment(R.id.fl,new ShoppingFragment());
                        break;
                    case R.id.rb_myebuy:
                        replacefragment(R.id.fl,new MyebuyFragment());
                        break;
                }
            }
        });
    }

    @Override
    public void initdata() {

    }

    @Override
    public void loaddata() {

    }


    @Override
    public void onClick(View view) {

    }

}
