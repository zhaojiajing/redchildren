package com.bwie.redchildren.holder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwie.redchildren.R;
import com.bwie.redchildren.bean.Home;

import bwie.mylibrary.GlideUtils;

/**
 * Created by zjj on 2016/11/16.
 */
public class ViewHolderType2 extends BaseViewHolder<Home.DataBean> {

    private final RecyclerView home_ScrollView;
    private final ImageView home_img22;

    public ViewHolderType2(View itemView) {
        super(itemView);
        home_img22 = (ImageView) itemView.findViewById(R.id.home_img22);
        home_ScrollView = (RecyclerView) itemView.findViewById(R.id.home_ScrollView);
    }

    @Override

    public void setData(final Context context, final Home.DataBean dataBean) {
        GlideUtils.loadpics(context, PREPICURL + dataBean.getTag().get(0).getPicUrl(), home_img22);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        home_ScrollView.setLayoutManager(linearLayoutManager);
        home_ScrollView.setAdapter(new RecyclerView.Adapter<Type2ViewHolder>() {
            @Override
            public Type2ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new Type2ViewHolder(LayoutInflater.from(context).inflate(R.layout.home_item22, parent, false));
            }

            @Override
            public void onBindViewHolder(Type2ViewHolder holder, int position) {
//holder.setData(context, dataBean.getTag().get(position));
                //不用向下分发,直接设置
                if(position!=dataBean.getTag().size()-1){
                    GlideUtils.loadpics(context, PREPICURL + dataBean.getTag().get(position + 1).getPicUrl(), holder.img_homeitem22);
                }
            }

            @Override
            public int getItemCount() {
                return dataBean.getTag().size();
            }
        });
    }


    class Type2ViewHolder extends BaseViewHolder<Home.DataBean.TagBean> {
        private final ImageView img_homeitem22;

        public Type2ViewHolder(View itemView) {
            super(itemView);
            img_homeitem22 = (ImageView) itemView.findViewById(R.id.img_homeitem22);
        }

        @Override
        public void setData(Context context, Home.DataBean.TagBean tagBean) {


        }
    }

}
