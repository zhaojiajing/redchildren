package com.bwie.redchildren.holder;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bwie.redchildren.R;
import com.bwie.redchildren.bean.Home;

import java.util.ArrayList;
import java.util.List;

import bwie.mylibrary.GlideUtils;

/**
 * Created by zjj on 2016/11/16.
 */
public class ViewHolderType0 extends BaseViewHolder<Home.DataBean> {


    private final ViewPager home_vp;
    private final LinearLayout home_ll_vpdot;
    private ArrayList<ImageView> dots;

    public ViewHolderType0(View itemView) {
        super(itemView);
        //写在构造方法中每次都是新new出来的集合
        dots = new ArrayList<ImageView>();
        home_vp = (ViewPager) itemView.findViewById(R.id.home_vp);
        home_ll_vpdot = (LinearLayout) itemView.findViewById(R.id.home_ll_vpdot);

    }

    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            //得到当前的item的position
            int currentItem = home_vp.getCurrentItem();
            //设置下一个position
            home_vp.setCurrentItem(++currentItem);
            //发送空的延时消息
            handler.sendEmptyMessageDelayed(0, 2000);
        }

        ;
    };

    @Override
    public void setData(final Context context, Home.DataBean dataBean) {
        //移除handler的事件:---多张图片快速滑动
        handler.removeCallbacksAndMessages(null);
        //移除线性布局中的所有View:---多个小圆点
        home_ll_vpdot.removeAllViews();
        final List<Home.DataBean.TagBean> tag = dataBean.getTag();
        loaddot(tag, context);

        //给viewpager设置适配器
        home_vp.setAdapter(new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView img = new ImageView(context);
                img.setScaleType(ImageView.ScaleType.FIT_XY);
                String preimgurl = "http://image1.suning.cn";
                GlideUtils.loadpics(context, preimgurl + tag.get(position % tag.size()).getPicUrl(), img);
                container.addView(img);
                //此监听写在instantiateItem方法内,加载图片对图片的监听
                img.setOnTouchListener(new View.OnTouchListener() {

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            //按下:移除回调和消息
                            case MotionEvent.ACTION_DOWN:
                                handler.removeCallbacksAndMessages(null);
                                break;
                            //抬开:
                            case MotionEvent.ACTION_UP:
                                handler.sendEmptyMessageDelayed(0, 2000);
                                break;
                            //取消:继续轮播
                            case MotionEvent.ACTION_CANCEL:
                                handler.sendEmptyMessageDelayed(0, 2000);
                                break;

                            default:
                                break;
                        }
                        //处理本次消费
                        return true;
                    }
                });
                return img;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public int getCount() {
                return Integer.MAX_VALUE;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });
        // 放在设置适配器之后,放设置适配器之前,不能向左滑动**************
        home_vp.setCurrentItem(tag.size() * 10000);
        handler.sendEmptyMessageDelayed(0, 2000);
        home_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dots.size(); i++) {
                    if (position % tag.size() == i) {
                        dots.get(i).setImageResource(R.drawable.dot_focus);
                    } else {
                        dots.get(i).setImageResource(R.drawable.dot_normal);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void loaddot(List<Home.DataBean.TagBean> tag, Context context) {

        dots.clear();
        for (int i = 0; i < tag.size(); i++) {
            ImageView dot = new ImageView(context);
            if (i == 0) {
                dot.setImageResource(R.drawable.dot_focus);
            } else {
                dot.setImageResource(R.drawable.dot_normal);
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            params.setMargins(5, 5, 5, 5);
            home_ll_vpdot.addView(dot, params);
            dots.add(dot);
        }
    }
}
