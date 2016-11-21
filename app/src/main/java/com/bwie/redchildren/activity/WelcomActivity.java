package com.bwie.redchildren.activity;

import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import com.bwie.redchildren.R;
import com.bwie.redchildren.adapter.VpAdater;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import butterknife.Bind;
import bwie.mylibrary.BaseActivity;

public class WelcomActivity extends BaseActivity {


    @Bind(R.id.vp)
    ViewPager vp;
    @Bind(R.id.img_pass)
    ImageView imgPass;
    @Bind(R.id.img_start)
    ImageView imgStart;
    private List<Integer> pics;
    private SharedPreferences sp;
    private int i;

    @Override
    public int bindlayout() {
        return R.layout.activity_welcom;
    }

    @Override
    public void initView() {


    }

    @Override
    public void initdata() {
        pics = new ArrayList<>();
        int[] drawables = {R.drawable.guide_page1, R.drawable.guide_page2, R.drawable.guide_page3};
        for (int i = 0; i < drawables.length; i++) {
            pics.add(drawables[i]);
        }
    }

    @Override
    public void loaddata() {
        sp = getSharedPreferences("record", MODE_PRIVATE);
        if (sp.getBoolean("second", false)) {
            onevp();
        } else {
            VpAdater adapter = new VpAdater(this, pics);
            vp.setAdapter(adapter);
            //把监听事件放到else里,否则第二次还出跳过的img,因为设置了选择第一张:就显示imgpass
            vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    //第三张
                    if(position==pics.size()-1){
                        imgStart.setVisibility(View.VISIBLE);
                        imgPass.setVisibility(View.INVISIBLE);
                        imgStart.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startAct(MainActivity.class);
                                finish();
                            }
                        });
                    }else{
                        imgPass.setVisibility(View.VISIBLE);
                        imgStart.setVisibility(View.INVISIBLE);
                        imgPass.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startAct(MainActivity.class);
                                finish();
                            }
                        });
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean("second", true);
        edit.commit();
    }


    private void onevp() {
        List<Integer> secondpic=new ArrayList<>();
        secondpic.add(R.drawable.load1);
        vp.setAdapter(new VpAdater(this,secondpic));
        final Timer timer = new Timer();
        i = 3;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    public void run() {
                        if (i-- == 0) {
                            startAct(MainActivity.class);
                            timer.cancel();// timer cancel;
                            finish();// finish掉页面****
                        }
                    }
                });

            }
        }, 0, 1000);// 参数二:延迟时间,参数三:间隔时间

    }
}
