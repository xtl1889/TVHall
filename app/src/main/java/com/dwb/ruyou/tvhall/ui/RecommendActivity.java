package com.dwb.ruyou.tvhall.ui;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.api.ApiConfig;
import com.dwb.ruyou.tvhall.api.TVhallApi;
import com.dwb.ruyou.tvhall.model.HomeModel;
import com.dwb.ruyou.tvhall.model.LiveShowItemBean;
import com.dwb.ruyou.tvhall.model.RecommendClassiedBean;
import com.dwb.ruyou.tvhall.model.RecommendModel;
import com.dwb.ruyou.tvhall.model.TestModel;
import com.dwb.ruyou.tvhall.model.TestModel_post;
import com.dwb.ruyou.tvhall.ui.adapter.RecommendAdapter;
import com.dwb.ruyou.tvhall.ui.base.BaseActivity;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvLinearLayoutManager;
import com.dwb.ruyou.tvhall.utils.DownloadFile;
import com.dwb.ruyou.tvhall.utils.LogUtil;
import com.dwb.ruyou.tvhall.utils.RetrofitUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecommendActivity extends BaseActivity {

    private TVhallApi tvHallApi,downApi;
    private Call<RecommendModel> recommendModelCall;
    private RecyclerView recommend_rv;
    private RecommendAdapter recommendAdapter;
    private RecommendModel recommendModel;
    private List<LiveShowItemBean> livingShowRoomList;//直播的list
    private List<RecommendClassiedBean> livingShowGameList;//分类的list
    private List<HomeModel> homeModelList;


    /**---------------------测试数据-------------------------------*/
    private Call<TestModel> callTestModel;
    private Button bt1,bt2,bt3,bt4;
    private Call<TestModel_post> callTestMode_postl;
    private Call<TestModel_post> callTestMode_post2;
    private Call<ResponseBody> downLoadFile;
    private String downApkUrl="http://user-update.ru-you.com/updateGame/t_test/梦中旅人_联网版TV.apk";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);
        tvHallApi= RetrofitUtils.getRestofitApi(ApiConfig.testUrl1,TVhallApi.class);
        recommendModelCall=tvHallApi.getHomePageInfo();
        initView();
        getHomeData();
    }

    private void initView() {
        recommend_rv= (RecyclerView) findViewById(R.id.recommend_rv);
        recommend_rv.setFocusable(false);
        recommend_rv.setItemAnimator(null);
//        tvRecyclerView.setParentUpView(parentUpView);
        TvLinearLayoutManager tvLinearLayoutManager=new TvLinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        LinearLayoutManager linearLayout=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//        TvGridLayoutManager tvGridLayoutManager=new TvGridLayoutManager(this,5);
//        tvGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recommendAdapter=new RecommendAdapter(this);
        recommend_rv.setLayoutManager(tvLinearLayoutManager);
//        recommend_rv.setSelectedItemOffset(180,180);
        recommend_rv.setAdapter(recommendAdapter);
    }

    private void getHomeData() {
        recommendModelCall.enqueue(new Callback<RecommendModel>() {
            @Override
            public void onResponse(Call<RecommendModel> call, Response<RecommendModel> response) {
                LogUtil.e("recommend","-------url-------"+call.request().url());
                if (response.body()!=null&&"SUCCESS".equals(response.body().getResult())){
                    recommendModel=response.body();
                    dealData();
                }else {
                    Toast.makeText(RecommendActivity.this,"获取推荐信息失败",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RecommendModel> call, Throwable t) {
                Toast.makeText(RecommendActivity.this,"无法获取推荐信息",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void dealData(){
        homeModelList=new ArrayList<>();
        if (recommendModel!=null){
            livingShowRoomList=recommendModel.getLivingShowRoomList();
            livingShowRoomList.add(4,new LiveShowItemBean("subscibe","myView"));
            livingShowRoomList.add(new LiveShowItemBean("game","myView"));
            homeModelList.add(new HomeModel("liveShow",livingShowRoomList,null,null));
            livingShowGameList=recommendModel.getLivingShowGameList();
            livingShowGameList.add(new RecommendClassiedBean("more"));
            homeModelList.add(new HomeModel("classied",null,livingShowGameList,null));
            homeModelList.add(new HomeModel("game",null,null,recommendModel.getCpGameList()));
            if (recommendAdapter!=null){
                recommendAdapter.addItems(homeModelList);
            }
        }
    }

    private List<TestModel> dataList=new ArrayList<>();
    private List<TestModel> creadData() {
        for (int i = 0; i <20 ; i++) {
            TestModel m1=new TestModel();
            if (i<10){
                m1.setViewTag(0);
                m1.setResult("主播--"+i);
            }else if (i>=0&&i<15){
                m1.setViewTag(1);
                m1.setResult("分类--"+i);
            }else {
                m1.setViewTag(2);
                m1.setResult("游戏--"+i);
            }
        dataList.add(m1);
        }
        return dataList;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_DOWN:
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
//                EventBus.getDefault().post(new TabToMainRequesfous(true,"1"));
                break;
            case KeyEvent.KEYCODE_BACK:
                LogUtil.e("TvRecyclerView", "-r--back---");
                break;
        }
        return super.onKeyDown(keyCode, event);
    }


    private void netWorkTest() {
        tvHallApi= RetrofitUtils.getRestofitApi(ApiConfig.testUrl1,TVhallApi.class);

        callTestModel=tvHallApi.getTestData1();
        callTestMode_postl=tvHallApi.getTestData2("dream","t_test");
        Map<String,String> map=new HashMap<>();
        map.put("appKey","dream");
        map.put("channelCode","t_test");
        callTestMode_post2=tvHallApi.getTestData22(map);

        downApi=RetrofitUtils.getRestofitApi("http://user-update.ru-you.com/updateGame/",TVhallApi.class);
        downLoadFile=downApi.downLoadFile();

//        bt1= (Button) findViewById(R.id.bt1);
//        bt2= (Button) findViewById(R.id.bt2);
//        bt3= (Button) findViewById(R.id.bt3);
//        bt4= (Button) findViewById(R.id.bt4);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callTestModel.enqueue(new Callback<TestModel>() {
                    @Override
                    public void onResponse(Call<TestModel> call, Response<TestModel> response) {
                        Log.e("url", "onResponse: ----resuart---"+response.body().toString());
                        Log.e("url", "onResponse: ----url----"+call.request().url() );
                    }

                    @Override
                    public void onFailure(Call<TestModel> call, Throwable t) {
                        Toast.makeText(RecommendActivity.this,"网络请求失败",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                callTestMode_postl.enqueue(new Callback<TestModel_post>() {
                    @Override
                    public void onResponse(Call<TestModel_post> call, Response<TestModel_post> response) {
                        Log.e("url", "onResponse: --post1--resuart---"+response.body().toString());
                        Log.e("url", "onResponse: --post1--url----"+call.request().url() );
                    }

                    @Override
                    public void onFailure(Call<TestModel_post> call, Throwable t) {

                    }
                });
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                callTestMode_post2.enqueue(new Callback<TestModel_post>() {
                    @Override
                    public void onResponse(Call<TestModel_post> call, Response<TestModel_post> response) {
                        Log.e("url", "onResponse: --post2--resuart---"+response.body().toString());
                        Log.e("url", "onResponse: --post2--url----"+call.request().url() );
                    }
                    @Override
                    public void onFailure(Call<TestModel_post> call, Throwable t) {

                    }
                });
            }
        });

        String fileName=downApkUrl.substring(downApkUrl.lastIndexOf("/")+1);
        final File downFile = new File(Environment.getExternalStorageDirectory(), fileName);

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        downLoadFile.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                final DownloadFile downloadFile=new DownloadFile(response.body());
                                new Thread(){
                                    @Override
                                    public void run() {
                                        super.run();
                                        boolean b=downloadFile.downFile(downFile);
                                        Log.e("url", "run: ---b--"+b );
                                    }
                                }.start();
//                                downloadFile.downFile(downFile,response.body());
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {

                            }
                        });
                    }
                }.start();

            }
        });
    }
}
