package com.bwie.redchildren.holder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.redchildren.R;
import com.bwie.redchildren.bean.Home;

import bwie.mylibrary.GlideUtils;

/**
 * Created by zjj on 2016/11/16.
 */
public class ViewHolderType1 extends BaseViewHolder<Home.DataBean> {

    private final RecyclerView home_gv;

    public ViewHolderType1(View itemView) {
        super(itemView);
        home_gv = (RecyclerView) itemView.findViewById(R.id.home_gv);
    }

    @Override
    public void setData(final Context context, final Home.DataBean dataBean) {
        //设置布局管理器
        home_gv.setLayoutManager(new GridLayoutManager(context, 4));
        //Adapter的泛型是VH
        home_gv.setAdapter(new RecyclerView.Adapter<Type1ViewHolder>() {

            @Override
            public Type1ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//加载布局文件是:子布局item R.layout.home_item2
                return new Type1ViewHolder(LayoutInflater.from(context).inflate(R.layout.home_item2, parent, false));
            }

            @Override
            public void onBindViewHolder(Type1ViewHolder holder, int position) {
                //集合中的对象
                holder.setData(context, dataBean.getTag().get(position));
            }

            @Override
            public int getItemCount() {
                return dataBean.getTag().size();
            }
        });
    }

    //写的位置:外部类内; setData使用到的数据: Home.DataBean.TagBean
    class Type1ViewHolder extends BaseViewHolder<Home.DataBean.TagBean> {
        private final ImageView img_homeitem2;
        private final TextView tv_homeitem2;

        public Type1ViewHolder(View itemView) {
            super(itemView);
            img_homeitem2 = (ImageView) itemView.findViewById(R.id.img_homeitem2);
            tv_homeitem2 = (TextView) itemView.findViewById(R.id.tv_homeitem2);
        }

        @Override
        public void setData(Context context, Home.DataBean.TagBean tagBean) {
            System.out.println("tagBean3-----" + tagBean);
            System.out.println("tv_homeitem2---" + tv_homeitem2);
            tv_homeitem2.setText(tagBean.getElementName());
            GlideUtils.loadpics(context, PREPICURL + tagBean.getPicUrl(), img_homeitem2);

        }
    }

}
