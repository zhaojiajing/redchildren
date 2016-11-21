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
public class ViewHolderType5 extends BaseViewHolder<Home.DataBean> {

    private final ImageView img_item5;

    public ViewHolderType5(View view5) {
        super(view5);
        img_item5 =(ImageView) view5.findViewById(R.id.img_item5);
    }

    @Override
    public void setData(Context context, Home.DataBean dataBean) {
GlideUtils.loadpics(context,PREPICURL+dataBean.getTag().get(0).getPicUrl(),img_item5);
    }
}
