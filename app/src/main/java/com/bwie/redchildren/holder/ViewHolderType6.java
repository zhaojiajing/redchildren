package com.bwie.redchildren.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bwie.redchildren.R;
import com.bwie.redchildren.bean.Home;
import com.bwie.redchildren.holder.BaseViewHolder;

import bwie.mylibrary.GlideUtils;

/**
 * Created by zjj on 2016/11/17.
 */
public class ViewHolderType6 extends BaseViewHolder<Home.DataBean> {

    private final ImageView img_homeitem6;

    public ViewHolderType6(View view6) {
        super(view6);
        img_homeitem6 =(ImageView)view6.findViewById(R.id.img_homeitem6);
    }

    @Override
    public void setData(Context context, Home.DataBean dataBean) {
        GlideUtils.loadpics(context,PREPICURL+dataBean.getTag().get(0).getPicUrl(),img_homeitem6);
    }
}
