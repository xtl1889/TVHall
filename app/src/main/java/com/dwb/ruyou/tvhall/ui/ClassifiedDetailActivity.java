package com.dwb.ruyou.tvhall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.api.ApiConfig;
import com.dwb.ruyou.tvhall.api.TVhallApi;
import com.dwb.ruyou.tvhall.model.FragmentModel;
import com.dwb.ruyou.tvhall.model.LiveShowList;
import com.dwb.ruyou.tvhall.model.eventbusmodel.MainToTabRequesfous;
import com.dwb.ruyou.tvhall.ui.adapter.Classified_detail_vp_adapter;
import com.dwb.ruyou.tvhall.ui.adapter.LiveShow_all_Adapter;
import com.dwb.ruyou.tvhall.ui.base.BaseActivity;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvGridLayoutManager;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvRecyclerView;
import com.dwb.ruyou.tvhall.utils.LogUtils;
import com.dwb.ruyou.tvhall.utils.RetrofitUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 分类详情界面
 * */
public class ClassifiedDetailActivity extends BaseActivity implements View.OnFocusChangeListener{

    private String[] sTitle={"全部","高端局","美女","新手上路"};
    private FragmentManager fm;
    private Classified_detail_vp_adapter vp_adapter;
    private TextView classified_detail_tv;
    private TvRecyclerView classified_detail_rv;
    private LiveShow_all_Adapter all_adapter;
    private TVhallApi tVhallApi;
    private Call<LiveShowList> liveShowListCall;
    private String name;
    private long id;


    /**当有标题时用到****现暂时无标题*/
    private LinearLayout classified_detail_title_layout;
    private ViewPager classified_detail_viewpager;

    private ArrayList<FragmentModel> mFragmentList = new ArrayList<>();
    private List<TextView> titleList2=new ArrayList<>();
    private List<ImageView> titleImageViewList=new ArrayList<>();

    private int titleFocusTag=-1;//当前获取焦点的标题
    private boolean isShowTitleImg;//是否显示标题下的图片
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classified_detail);
        EventBus.getDefault().register(this);
        Intent intent=getIntent();
        if (intent!=null){
            name=intent.getStringExtra("name");
            id=intent.getIntExtra("id",0);
        }
        tVhallApi= RetrofitUtils.getRestofitApi(ApiConfig.testUrl1,TVhallApi.class);
        liveShowListCall=tVhallApi.getLiveShowList(id);
        initView();

    }

    private void initView() {
        classified_detail_tv= (TextView) findViewById(R.id.classified_detail_tv);
        classified_detail_rv= (TvRecyclerView) findViewById(R.id.classified_detail_rv);
        classified_detail_tv.setText(name);
        TvGridLayoutManager tvGridLayoutManager=new TvGridLayoutManager(this,4);
        tvGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        all_adapter=new LiveShow_all_Adapter(this,classified_detail_rv);

//        mTvRecyclerView.setFocusable(false);
        classified_detail_rv.setItemAnimator(null);
        classified_detail_rv.setLayoutManager(tvGridLayoutManager);
//        mTvRecyclerView.setSelectedItemOffset(180,180);
        classified_detail_rv.setAdapter(all_adapter);

        getLiveShowData();
        /**-------------------------------------------*/
//        classified_detail_title_layout= (LinearLayout) findViewById(R.id.classified_detail_title_layout);
//        classified_detail_viewpager= (ViewPager) findViewById(R.id.classified_detail_viewpager);
//        fm=getSupportFragmentManager();
//        for (int i = 0; i < sTitle.length; i++) {
//            mFragmentList.add(new FragmentModel(sTitle[i],new Classified_Detail_Fragment()));
//        }
//        vp_adapter=new Classified_detail_vp_adapter(fm,mFragmentList,this);
//        //liveshow_viewPager.setOffscreenPageLimit(3);//指定ViewPager缓存Fragment的个数
//        classified_detail_viewpager.setAdapter(vp_adapter);
//        classified_detail_viewpager.setCurrentItem(0);//初始页面
    }


    private void getLiveShowData() {
        liveShowListCall.enqueue(new Callback<LiveShowList>() {
            @Override
            public void onResponse(Call<LiveShowList> call, Response<LiveShowList> response) {
                if (response.body()!=null&&"SUCCESS".equals(response.body().getResult())){
                    if (all_adapter!=null){
                        all_adapter.addItems(response.body().getList());
                    }
                }else {
                    LogUtils.LOGD("classifiedDetail------url-----"+call.request().url());
                    Toast.makeText(ClassifiedDetailActivity.this,"获取直播列表失败!",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LiveShowList> call, Throwable t) {
                Toast.makeText(ClassifiedDetailActivity.this,"无法获取直播列表!",Toast.LENGTH_SHORT).show();
            }
        });
    }



    /**利用LinearLayout添加游戏标题*/
    private void addLiveShowTtileView(){
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
//        lp.setMarginStart(10);
        for (int i = 0; i < sTitle.length; i++) {
            View view= LayoutInflater.from(this).inflate(R.layout.game_title_layout,null);
//            view.setLayoutParams(lp);
            TextView tv= (TextView) view.findViewById(R.id.game_title_tv);
            ImageView imageView= (ImageView) view.findViewById(R.id.game_title_img);
            tv.setOnFocusChangeListener(this);
            tv.setText(sTitle[i]);
            tv.setTag(i);
            classified_detail_title_layout.addView(view);
            titleList2.add(tv);
            titleImageViewList.add(imageView);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_DOWN:
                isShowTitleImg=true;
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:

                if (titleFocusTag==titleList2.size()-1){//如果最右侧标题获取焦点  再按向右键  让焦点不再改变
                    return true;
                }
                break;
            case KeyEvent.KEYCODE_BACK:
                finish();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Subscribe(threadMode = ThreadMode.POSTING) // ThreadMode is optional here
    public void onMessage(MainToTabRequesfous requesfous) {
//        Log.e("enentBus", "onMessage: ---------"+requesfous.getTitleTag() );
        if (requesfous!=null&&requesfous.isReques()&&"3".equals(requesfous.getTitleTag())){
            titleList2.get(titleFocusTag).requestFocus();
            isShowTitleImg=false;
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (b){
            int i= (int) view.getTag();
            classified_detail_viewpager.setCurrentItem(i);
            titleFocusTag=i;
            titleImageViewList.get(titleFocusTag).setVisibility(View.INVISIBLE);
        }else {
            if (isShowTitleImg){
                titleImageViewList.get(titleFocusTag).setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
