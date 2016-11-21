package com.bwie.redchildren.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwie.redchildren.R;
import com.bwie.redchildren.activity.MainActivity;
import com.bwie.redchildren.activity.WelcomActivity;

import java.util.List;

import butterknife.Bind;

/**
 * Created by zjj on 2016/11/10.
 */
public class VpAdater extends PagerAdapter {

    private final Context context;
    private final List<Integer> pics;
//    @Bind(R.id.img_vp)
//    ImageView imgVp;

    public VpAdater(Context context, List<Integer> pics) {
        this.context = context;
        this.pics = pics;
    }

    @Override
    public int getCount() {
        return pics.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v = View.inflate(context, R.layout.vp_img, null);
        ImageView imgVp = (ImageView) v.findViewById(R.id.img_vp);
        imgVp.setImageResource(pics.get(position));
//        final WelcomActivity wel = (WelcomActivity) context;
//        ImageView img_pass = (ImageView) wel.findViewById(R.id.img_pass);
//        ImageView img_start = (ImageView) wel.findViewById(R.id.img_start);
//        if (position == pics.size() - 1) {
//            img_start.setVisibility(View.VISIBLE);
//            img_pass.setVisibility(View.INVISIBLE);
//            img_start.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    wel.startAct(MainActivity.class);
//                }
//            });
//        } else {
//            img_start.setVisibility(View.INVISIBLE);
//            img_pass.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    wel.startAct(MainActivity.class);
//                }
//            });
//        }
        //添加
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
