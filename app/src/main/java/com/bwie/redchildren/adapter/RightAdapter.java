package com.bwie.redchildren.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.redchildren.R;
import com.bwie.redchildren.bean.ChildrenBean;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

import bwie.mylibrary.GlideUtils;

/**
 * Created by zjj on 2016/11/13.
 */
public class RightAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final List<ChildrenBean> cs;
    private int Head = 0;
    private int GENERAL = 1;

    public RightAdapter(Context context, List<ChildrenBean> cs) {
        this.context = context;
        this.cs = cs;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==Head){
            View view = LayoutInflater.from(context).inflate(R.layout.right_tv, parent, false);
            return new TopViewHolder(view);
        }else{
            View view = LayoutInflater.from(context).inflate(R.layout.right_img, parent, false);
            return new ButtomViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ChildrenBean c = cs.get(position);
        //判断是holder是属于哪个
       if(holder instanceof TopViewHolder){
           ((TopViewHolder) holder).tv_right.setText(c.getDirName());
       }else if(holder instanceof  ButtomViewHolder){
           ((ButtomViewHolder) holder).tv2_right.setText(c.getDirName());
           //BitmapUtils bu=new BitmapUtils(context);
         //  bu.display(((ButtomViewHolder) holder).img2_right,c.getImgApp());
           GlideUtils.loadpics(context,c.getImgApp(),((ButtomViewHolder) holder).img2_right);

       }
    }

    @Override
    public int getItemCount() {
        return cs.size();
    }
//for必要?
    @Override
    public int getItemViewType(int position) {
        for (int i = 0; i < cs.size(); i++) {
            if (cs.get(position).isHeader()) {
                return Head;
            } else {
                return GENERAL;
            }
        }
        //写在for循环之外***
        return super.getItemViewType(position);
    }


    class TopViewHolder extends RecyclerView.ViewHolder {
        private   TextView tv_right;

        public TopViewHolder(View itemView) {
            super(itemView);
            tv_right=(TextView)itemView.findViewById(R.id.tv_right);
        }
    }

    class ButtomViewHolder extends RecyclerView.ViewHolder {

        private   TextView tv2_right;
        private   ImageView img2_right;

        public ButtomViewHolder(View itemView) {
            super(itemView);
            tv2_right=(TextView)  itemView.findViewById(R.id.tv2_right);
            img2_right=(ImageView)itemView.findViewById(R.id.img2_right);

        }
    }


}
