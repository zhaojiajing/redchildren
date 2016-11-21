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
 * Created by zjj on 2016/11/17.
 */
public class ViewHolderType7 extends BaseViewHolder<Home.DataBean> {

    private final RecyclerView recycleview_homeitem7;

    public ViewHolderType7(View view7) {
        super(view7);
        recycleview_homeitem7 =(RecyclerView)view7.findViewById(R.id.recycleview_homeitem7);
    }

    @Override
    public void setData(final Context context, final Home.DataBean dataBean) {
        recycleview_homeitem7.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
    recycleview_homeitem7.setAdapter(new RecyclerView.Adapter<Type7ViewHolder>(){
        @Override
        public Type7ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Type7ViewHolder(LayoutInflater.from(context).inflate(R.layout.home_item7,parent,false));
        }

        @Override
        public void onBindViewHolder(Type7ViewHolder holder, int position) {
GlideUtils.loadpics(context,PREPICURL+dataBean.getTag().get(position).getPicUrl(),holder.img_homeitem7);
        }

        @Override
        public int getItemCount() {
            return dataBean.getTag().size();
        }
    });
    }
    class Type7ViewHolder extends BaseViewHolder<Home.DataBean>{
        private final ImageView img_homeitem7;

        public Type7ViewHolder(View itemView) {
            super(itemView);
            img_homeitem7= (ImageView)itemView.findViewById(R.id.img_homeitem7);
        }

        @Override
        public void setData(Context context, Home.DataBean dataBean) {

        }
    }

}
