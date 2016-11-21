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
public class ViewHolderType4 extends BaseViewHolder<Home.DataBean> {
    private final ImageView img1_type4;
    private final ImageView img2_type4;
    private final ImageView img3_type4;
    private final ImageView img4_type4;
    private final ImageView img5_type4;
    private final ImageView img6_type4;
    private final ImageView img7_type4;

    public ViewHolderType4(View view4) {
        super(view4);
        img1_type4=(ImageView)view4.findViewById(R.id.img1_type4);
        img2_type4=(ImageView)view4.findViewById(R.id.img2_type4);
        img3_type4=(ImageView)view4.findViewById(R.id.img3_type4);
        img4_type4=(ImageView)view4.findViewById(R.id.img4_type4);
        img5_type4=(ImageView)view4.findViewById(R.id.img5_type4);
        img6_type4=(ImageView)view4.findViewById(R.id.img6_type4);
        img7_type4=(ImageView)view4.findViewById(R.id.img7_type4);
    }

    @Override
    public void setData(Context context, Home.DataBean dataBean) {
       // img1_type4
        GlideUtils.loadpics(context,PREPICURL+dataBean.getTag().get(0).getPicUrl(),img1_type4);
        GlideUtils.loadpics(context,PREPICURL+dataBean.getTag().get(1).getPicUrl(),img2_type4);
        GlideUtils.loadpics(context,PREPICURL+dataBean.getTag().get(2).getPicUrl(),img3_type4);
        GlideUtils.loadpics(context,PREPICURL+dataBean.getTag().get(3).getPicUrl(),img4_type4);
        GlideUtils.loadpics(context,PREPICURL+dataBean.getTag().get(4).getPicUrl(),img5_type4);
        GlideUtils.loadpics(context,PREPICURL+dataBean.getTag().get(5).getPicUrl(),img6_type4);
        GlideUtils.loadpics(context,PREPICURL+dataBean.getTag().get(6).getPicUrl(),img7_type4);
    }
}
