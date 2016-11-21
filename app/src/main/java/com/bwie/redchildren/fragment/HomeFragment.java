package com.bwie.redchildren.fragment;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bwie.redchildren.R;
import com.bwie.redchildren.adapter.HomeAdapter;
import com.bwie.redchildren.bean.Home;
import com.google.gson.Gson;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import bwie.mylibrary.BaseFragment;
import bwie.mylibrary.OkHttpUtils;
import bwie.mylibrary.StreamUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by zjj on 2016/11/10.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private List<ImageView> dots;
    List<Home.DataBean> mydata = new ArrayList<>();
    private RecyclerView recycleview_home;
    private LinearLayoutManager layoutManager;
    private ImageView backtotop;
    public static final int REQUEST_CODE = 111;
    Handler handler = new Handler() {
        @TargetApi(Build.VERSION_CODES.M)
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                String json = (String) msg.obj;
                Home home = new Gson().fromJson(json, Home.class);
                List<Home.DataBean> data = home.getData();
//            for (int i = 0; i < data.size(); i++) {
//                Home.DataBean dataBean = data.get(i);
//            }
                //布局管理器
                layoutManager = new LinearLayoutManager(getActivity());
                recycleview_home.setLayoutManager(layoutManager);
                //集合是需要的数据
                for (int i = 0; i <= 2; i++) {
                    mydata.add(data.get(i));
                }
                /**
                 * 把5.6.7 tag中的1.2 加到了4中
                 */
                data.get(4).getTag().addAll(data.get(5).getTag());
                data.get(4).getTag().addAll(data.get(6).getTag());
                data.get(4).getTag().addAll(data.get(7).getTag());
                mydata.add(data.get(4));

                data.get(9).getTag().addAll(data.get(10).getTag());
                data.get(9).getTag().addAll(data.get(11).getTag());
                mydata.add(data.get(9));

                mydata.add(data.get(13));

                for (int i = 14; i <= 21; i++) {
                    mydata.add(data.get(i));
                }
                for (int i = 23; i <= 24; i++) {
                    mydata.add(data.get(i));
                }
                mydata.add(data.get(26));
                mydata.add(data.get(28));
                mydata.add(data.get(30));
                mydata.add(data.get(32));
                mydata.add(data.get(33));
                mydata.add(data.get(34));//添加34 是为了放TextView

                System.out.println("mydata的长度:" + mydata.size());

              /*  for (int i = 4; i <=7; i++) {
                    tempdata.add(data.get(i));
                }
                mydata.addAll(tempdata);
                System.out.println("mydata的长度:"+mydata.size());长度为7不可取*/

                recycleview_home.setAdapter(new HomeAdapter(getActivity(), mydata));
                /**
                 * 给recycleView设置滑动监听
                 */
                recycleview_home.setOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                        //是布局管理器的方法判断最后可见item的position
                        if (layoutManager.findLastVisibleItemPosition() > 7) {
                            backtotop.setVisibility(View.VISIBLE);
                        }
                        //置顶图片消失
                         if(layoutManager.findFirstVisibleItemPosition()==0&&newState==RecyclerView.SCROLL_STATE_IDLE){
                             backtotop.setVisibility(View.INVISIBLE);
                         }
                    }
                });
            }
        }

    };
    private ImageView img_scan;

    //在onCreate()
    @Override
   public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ZXingLibrary.initDisplayOpinion(getActivity());
    }
    @Override
    public int bindlayout() {
        return R.layout.homefragment;
    }

    @Override
    public void initView() {
        View view = getmRootView();
        recycleview_home = (RecyclerView) view.findViewById(R.id.recycleview_home);
        backtotop = (ImageView) view.findViewById(R.id.imageView);
        img_scan = (ImageView)view.findViewById(R.id.img_scan);
        backtotop.setOnClickListener(this);
        img_scan.setOnClickListener(this);
    }

    @Override
    public void initdata() {
       /* String url = "http://lib.suning.com/app/redbaby/80000_5.0.0-459.json";
        OkHttpUtils.get(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                showToast(getActivity(), "请求数据失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                handler.obtainMessage(1, json).sendToTarget();
            }
        });*/
        try {
            InputStream inputStream = getActivity().getAssets().open("redbabyjson.txt");
            String json = StreamUtils.toStr(inputStream, "gbk");
            handler.obtainMessage(1, json).sendToTarget();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void loaddata() {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
           case R.id.imageView:// 点击滑动到顶部,并且控件不可见
               recycleview_home.smoothScrollToPosition(0);
               recycleview_home.stopNestedScroll();
               break;
            case R.id.img_scan:
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
        }

        //recycleview_home.stopScroll();
      //  if(layoutManager.findFirstVisibleItemPosition()==0){
         //   backtotop.setVisibility(View.INVISIBLE);
      //  }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getActivity(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
