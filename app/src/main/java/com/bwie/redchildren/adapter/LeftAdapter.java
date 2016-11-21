package com.bwie.redchildren.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bwie.redchildren.R;
import com.bwie.redchildren.bean.RsBean;
import java.util.List;

/**
 * Created by zjj on 2016/11/11.
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.LeftViewHoler> {
    private final Context context;
    private final List<RsBean> rs;

    OnItemClickListener mOnItemClickListener;
    public LeftAdapter(Context context, List<RsBean> rs) {
        this.context = context;
        this.rs = rs;
    }

    @Override
    public LeftViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
    //    View v = LayoutInflater.from(context).inflate(R.layout.left_item,parent,false);
        //得到视图*****如果最后一个参数是parent 报:java.lang.IllegalStateException
  View v = View.inflate(context, R.layout.left_item, null);
        LeftViewHoler vh = new LeftViewHoler(v);
        return vh;
    }
    //1.定义一个接口:点击item事件
    public interface OnItemClickListener{
        void onClick( int position);
        void onLongClick( int position);
    }
    //2.设置set方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this. mOnItemClickListener=onItemClickListener;
    }
    @Override
    public void onBindViewHolder(LeftViewHoler holder, final int position) {
        holder.tv_leftitem.setText(rs.get(position).getDirName());
        //判断不为空
        if( mOnItemClickListener!= null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // 调用自定义点击方法
                    mOnItemClickListener.onClick(position);
                }
            });
        }
        if(rs.get(position).ischecked()){
            holder.tv_leftitem.setTextColor(context.getResources().getColor(R.color.tvcheckedcolor));
            holder.view_background.setVisibility(View.VISIBLE);
            holder.ll_left.setBackgroundColor(context.getResources().getColor(R.color.itemuncheckedbackground));
        }else{
            holder.tv_leftitem.setTextColor(Color.BLACK);
            holder.view_background.setVisibility(View.INVISIBLE);
            holder.ll_left.setBackgroundColor(context.getResources().getColor(R.color.itemleftbackground));
        }
    }

    @Override
    public int getItemCount() {
        return rs.size();
    }

    class LeftViewHoler extends RecyclerView.ViewHolder {
        //生成成员变量,否则上面调不到
        private final TextView tv_leftitem;
        private final View view_background;
        private final LinearLayout ll_left;

        //有参构造
        public LeftViewHoler(View itemView) {
            super(itemView);

            tv_leftitem = (TextView) itemView.findViewById(R.id.tv_leftitem);
            view_background=(View)itemView.findViewById(R.id.view_background);
            ll_left=(LinearLayout)itemView.findViewById(R.id.ll_left);
        }
    }

}
