package com.bwie.redchildren.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.bwie.redchildren.R;
import com.bwie.redchildren.adapter.LeftAdapter;
import com.bwie.redchildren.adapter.RightAdapter;
import com.bwie.redchildren.bean.ChildrenBean;
import com.bwie.redchildren.bean.Classes;
import com.bwie.redchildren.bean.RsBean;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import bwie.mylibrary.BaseFragment;
import bwie.mylibrary.DividerItemDecoration;
import bwie.mylibrary.StreamUtils;

/**
 * Created by zjj on 2016/11/10.
 */
public class ClassFragment extends BaseFragment {

    private RecyclerView reLv;
    private LeftAdapter adapter;
    private int checkindex = 0;
    private RightAdapter radapter;
    private RecyclerView reGv;
    private List<RsBean> rs;
    List<ChildrenBean> cs = new ArrayList<>();

    @Override
    public int bindlayout() {
        return R.layout.classfragment;
    }

    @Override
    public void initView() {
        reLv = (RecyclerView) getmRootView().findViewById(R.id.re_lv);
        reLv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        reGv = (RecyclerView) getmRootView().findViewById(R.id.re_gv);
    }

    @Override
    public void initdata() {


    }

    @Override
    public void loaddata() {
        //模拟网络请求,放在子线程中
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    InputStream in = getActivity().getAssets().open("category.txt");
                    String json = StreamUtils.toStr(in, "utf-8");
                    //    System.out.println("josn"+json);
                    Classes classes = new Gson().fromJson(json, Classes.class);
                    // System.out.println("解析出来的"+classes);
                    rs = classes.getRs();
                    reLv.post(new Runnable() {
                        @Override
                        public void run() {
                            //默认第一个为true
                            rs.get(checkindex).setIschecked(true);
                            adapter = new LeftAdapter(getActivity(), rs);
                            reLv.setLayoutManager(new LinearLayoutManager(getActivity()));
                            reLv.setAdapter(adapter);
                            //右边默认加载第一条
                            update(checkindex);
                            adapter.setOnItemClickListener(new LeftAdapter.OnItemClickListener() {
                                @Override
                                public void onClick(int position) {
                                    //之前的设为false
                                    rs.get(checkindex).setIschecked(false);
                                    //现在的设为true
                                    rs.get(position).setIschecked(true);
                                    //把现在的赋值给之前的
                                    checkindex = position;
                                    //通知适配器,否则不起效果:对应右边加载数据
                                    update(position);
                                }
                                @Override
                                public void onLongClick(int position) {

                                }
                            });
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
    private void update(int position) {
        adapter.notifyDataSetChanged();


        /**
         * 右:
         * 1.加载某一个RsBean对象
         * 2.加载ChildrenBean: cs.addAll 只加载一遍不用遍历(若遍历了就加载了8次集合)
         */
        cs.clear();
        //for (RsBean r : rs) {//1.加载某一个RsBean对象 不用遍历
        RsBean r = rs.get(position);
        final List<ChildrenBean> children = r.getChildren();
            for (int i = 0; i < children.size(); i++) {
                children.get(i).setHeader(true);
                cs.add(children.get(i));
                //  String dirName = children.get(i).getDirName();//cs.add(dirName);
               // for (int j = 0; j < children.get(i).getChildren().size(); j++) {
                    cs.addAll(children.get(i).getChildren());
                    //  for (ChildrenBean c : children.get(i).getChildren()) {c.getDirName();c.getImgApp()}
               // }

            }
/**
 * 记得设置布局管理器:否则不出效果
 */
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        //给布局管理器设置setSpanSizeLookup(),辨别是占1个还是3个
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return   cs.get(position).isHeader()?3:1;
                }
            });
            reGv.setLayoutManager(gridLayoutManager);
       // 判断radapter是否为空
        if (radapter != null) {
            radapter.notifyDataSetChanged();
        } else {
            radapter = new RightAdapter(getActivity(), cs);
            reGv.setAdapter(radapter);
        }
     //   }
    }

}

