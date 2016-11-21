package com.bwie.redchildren.holder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bwie.redchildren.R;
import com.bwie.redchildren.bean.Home;
import java.util.ArrayList;
import java.util.List;
import bwie.mylibrary.GlideUtils;

/**
 * Created by zjj on 2016/11/17.
 */
public class ViewHolderType3 extends BaseViewHolder<Home.DataBean> {

    private final ImageView img_homeitem3;
    private final RecyclerView recycleview_homeitem3;
    List<Home.DataBean.TagBean> mytag=new ArrayList<>();
    public ViewHolderType3(View view3) {
        super(view3);
        img_homeitem3 =(ImageView)view3.findViewById(R.id.img_homeitem3);
        recycleview_homeitem3 =(RecyclerView)view3.findViewById(R.id.recycleview_homeitem3);
    }

    @Override
    public void setData(final Context context, final Home.DataBean dataBean) {


        //上面的imageview设置值
        GlideUtils.loadpics(context, PREPICURL+dataBean.getTag().get(0).getPicUrl(),img_homeitem3);
        for(int i=0;i<dataBean.getTag().size();i++){
            if(i!=0){
                mytag.add( dataBean.getTag().get(i));
            }
        }
        //
        recycleview_homeitem3.setLayoutManager(new GridLayoutManager(context,2));
        recycleview_homeitem3.setAdapter(new RecyclerView.Adapter<Type3ViewHolder>() {

            @Override
            public Type3ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new Type3ViewHolder(LayoutInflater.from(context).inflate(R.layout.home_item3,parent,false));
            }

            @Override
            public void onBindViewHolder(Type3ViewHolder holder, int position) {
                System.out.println("position----"+position);
              // 不好用,留第一个空位
                /* if(position!=0){
                    System.out.println("图片地址集合"+dataBean.getTag().get(position).getPicUrl());
                    GlideUtils.loadpics(context,PREPICURL+dataBean.getTag().get(position).getPicUrl(), holder.img_homeitem3x);
                }*/

                    GlideUtils.loadpics(context,PREPICURL+mytag.get(position).getPicUrl(), holder.img_homeitem3x);

            }

            @Override
            public int getItemCount() {
                /**
                 * 长度是只存下面图片的集合mytag.size()********
                 */
                return mytag.size();
            }
        });
    }
class Type3ViewHolder extends BaseViewHolder<Home.DataBean.TagBean>{
    private final ImageView img_homeitem3x;

    public Type3ViewHolder(View itemView) {
        super(itemView);
        img_homeitem3x=(ImageView)itemView.findViewById(R.id.img_homeitem3x);
    }

    @Override
    public void setData(Context context, Home.DataBean.TagBean tagBean) {

    }
}


}
