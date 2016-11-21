package com.bwie.redchildren.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.redchildren.R;
import com.bwie.redchildren.bean.Home;
import com.bwie.redchildren.holder.BaseViewHolder;
import com.bwie.redchildren.holder.ViewHolderType0;
import com.bwie.redchildren.holder.ViewHolderType1;
import com.bwie.redchildren.holder.ViewHolderType2;
import com.bwie.redchildren.holder.ViewHolderType3;
import com.bwie.redchildren.holder.ViewHolderType4;
import com.bwie.redchildren.holder.ViewHolderType5;
import com.bwie.redchildren.holder.ViewHolderType6;
import com.bwie.redchildren.holder.ViewHolderType7;
import com.bwie.redchildren.holder.ViewHolderType8;

import java.util.List;

/**
 * Created by zjj on 2016/11/15.
 */
public class HomeAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private final int TYPE0 = 0;
    private final int TYPE1 = 1;
    private final int TYPE2 = 2;
    private final int TYPE3 = 3;
    private final int TYPE4 = 4;
    private final int TYPE5 = 5;
    private final int TYPE6 = 6;
    private final int TYPE7 = 7;
    private final int TYPE8 = 8;
    private final int TYPE9 = 9;
    private final Context context;
    private final List<Home.DataBean> data;

    public HomeAdapter(Context context, List<Home.DataBean> data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public int getItemViewType(int position) {
        //返回类型
        return getType(position);

    }

    private int getType(int position) {
        //第0条返回TYPE0
        switch (position) {
            case 0:
                return TYPE0;
            case 1:
                return TYPE1;
            case 2:
                return TYPE2;
            case 3:
                return TYPE3;
            case 4:
                return TYPE4;
            case 5:
            case 14:
            case 20:
                return TYPE5;//一张标题图
            case 6:
            case 8:
            case 10:
            case 12:
                return TYPE6;//一张大图
            case 7:
            case 9:
            case 11:
            case 13:
                return TYPE7;//recyclerView_list_horizontal
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                return TYPE8;//一张大图高
            case 21:
                return TYPE9;//最后的TextView
        }
        return 0;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE0:
                View view = LayoutInflater.from(context).inflate(R.layout.home_viewpager, parent, false);
                return new ViewHolderType0(view);
            case TYPE1:
                View view1 = LayoutInflater.from(context).inflate(R.layout.home_type1, parent, false);
                return new ViewHolderType1(view1);
            case TYPE2:
                View view2 = LayoutInflater.from(context).inflate(R.layout.home_type2, parent, false);
                return new ViewHolderType2(view2);
            case TYPE3:
                View view3 = LayoutInflater.from(context).inflate(R.layout.home_type3, parent, false);
                return new ViewHolderType3(view3);
            case TYPE4:
                View view4 = LayoutInflater.from(context).inflate(R.layout.home_type4, parent, false);
                return new ViewHolderType4(view4);
            case TYPE5:
                View view5 = LayoutInflater.from(context).inflate(R.layout.home_type5, parent, false);
                return new ViewHolderType5(view5);
            case TYPE6:
                View view6 = LayoutInflater.from(context).inflate(R.layout.home_type6, parent, false);
                return new ViewHolderType6(view6);
            case TYPE7:
                View view7 = LayoutInflater.from(context).inflate(R.layout.home_type7, parent, false);
                return new ViewHolderType7(view7);
            case TYPE8:
                View view8 = LayoutInflater.from(context).inflate(R.layout.home_type8, parent, false);
                return new ViewHolderType8(view8);
            case TYPE9:
                View view9 = LayoutInflater.from(context).inflate(R.layout.home_type9, parent, false);
                return new ViewHolderType9(view9);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

        holder.setData(context, data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
