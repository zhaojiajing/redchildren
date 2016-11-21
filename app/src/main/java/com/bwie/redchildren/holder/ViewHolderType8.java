package com.bwie.redchildren.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bwie.redchildren.R;
import com.bwie.redchildren.bean.Home;

import bwie.mylibrary.GlideUtils;

/**
 * Created by zjj on 2016/11/17.
 */
public class ViewHolderType8 extends BaseViewHolder<Home.DataBean> {

    private final ImageView img_homeitem8;

    public ViewHolderType8(View view8) {
        super(view8);
        img_homeitem8 =(ImageView)view8.findViewById(R.id.img_homeitem8);
    }

    @Override
    public void setData(Context context, Home.DataBean dataBean) {
        GlideUtils.loadpics(context,PREPICURL+dataBean.getTag().get(0).getPicUrl(),img_homeitem8);
    }
}
