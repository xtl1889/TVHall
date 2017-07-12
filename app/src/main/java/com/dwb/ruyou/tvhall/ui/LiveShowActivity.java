package com.dwb.ruyou.tvhall.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
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
import com.dwb.ruyou.tvhall.model.LiveShowTitle;
import com.dwb.ruyou.tvhall.model.eventbusmodel.MainToTabRequesfous;
import com.dwb.ruyou.tvhall.model.eventbusmodel.TabToMainRequesfous;
import com.dwb.ruyou.tvhall.ui.adapter.LiveShow_fragment_vp_adapter;
import com.dwb.ruyou.tvhall.ui.base.BaseActivity;
import com.dwb.ruyou.tvhall.ui.fragment.LiveShow_All_Fragment;
import com.dwb.ruyou.tvhall.utils.RetrofitUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveShowActivity extends BaseActivity implements View.OnFocusChangeListener{

    private String[] sTitle={"全部","王者","穿越","LOL"};
    private FragmentManager fm;
    private LinearLayout liveshow_title_layout;
    private ViewPager liveshow_viewPager;
    LiveShow_fragment_vp_adapter vpAdapter;

    private ArrayList<FragmentModel> mFragmentList = new ArrayList<>();
    private List<TextView> titleList2=new ArrayList<>();
    private List<ImageView> titleImageViewList=new ArrayList<>();

    private int titleFocusTag=-1;//当前获取焦点的标题
    private boolean isShowTitleImg;//是否显示标题下的图片

    private TVhallApi tVhallApi;
    private Call<LiveShowTitle> liveShowTitleCall;
    private LiveShowTitle liveShowTitle;
    private int titleLeanth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liveshow);
        EventBus.getDefault().register(this);
        tVhallApi= RetrofitUtils.getRestofitApi(ApiConfig.testUrl1,TVhallApi.class);
        liveShowTitleCall=tVhallApi.getLiveShowTitle();
        initView();
//        initFragment();
    }

    private void initView() {
        liveshow_title_layout= (LinearLayout) findViewById(R.id.liveshow_title_layout);
        liveshow_viewPager= (ViewPager) findViewById(R.id.liveshow_viewPager);
        gitTitleData();
        addLiveShowTtileView();
    }

    private void initFragment() {
        mFragmentList.clear();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction ft=fragmentManager.beginTransaction();
        for (int i = 0; i < titleLeanth; i++) {
            int liveShowId=liveShowTitle.getList().get(i).getId();
            mFragmentList.add(new FragmentModel(liveShowTitle.getList().get(i).getName(),new LiveShow_All_Fragment(liveShowId)));
        }
//        ft.commitAllowingStateLoss();
        vpAdapter=new LiveShow_fragment_vp_adapter(fragmentManager,mFragmentList,this);
        //liveshow_viewPager.setOffscreenPageLimit(3);//指定ViewPager缓存Fragment的个数
        liveshow_viewPager.setAdapter(vpAdapter);
        liveshow_viewPager.setCurrentItem(0);//初始页面

    }

    /**利用LinearLayout添加游戏标题*/
    private void addLiveShowTtileView(){

        for (int i = 0; i < titleLeanth; i++) {
            View view= LayoutInflater.from(this).inflate(R.layout.game_title_layout,null);
            TextView tv= (TextView) view.findViewById(R.id.game_title_tv);
            ImageView imageView= (ImageView) view.findViewById(R.id.game_title_img);
            tv.setOnFocusChangeListener(this);
            tv.setText(liveShowTitle.getList().get(i).getName());
            tv.setTag(i);
            liveshow_title_layout.addView(view);
            titleList2.add(tv);
            titleImageViewList.add(imageView);
        }
    }

    private void gitTitleData() {
        liveShowTitleCall.enqueue(new Callback<LiveShowTitle>() {
            @Override
            public void onResponse(Call<LiveShowTitle> call, Response<LiveShowTitle> response) {
                if (response.body()!=null&&"SUCCESS".equals(response.body().getResult())){
                    liveShowTitle=response.body();
                    titleLeanth=liveShowTitle.getList().size();
                    addLiveShowTtileView();
                    initFragment();
                }else {
                    Toast.makeText(LiveShowActivity.this,"获取直播标题失败!",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LiveShowTitle> call, Throwable t) {
                Toast.makeText(LiveShowActivity.this,"无法获取直播标题!",Toast.LENGTH_SHORT).show();
            }
        });
    }
    /**
     * (当一级页面按向下按钮时  二级级页面标题显示焦点   目前该功能取消)
     * 当item向上按时  标题回复焦点
     * */
    @Subscribe(threadMode = ThreadMode.POSTING) // ThreadMode is optional here
    public void onMessage(MainToTabRequesfous requesfous) {
//        Log.e("enentBus", "onMessage: ---------"+requesfous.getTitleTag() );
        if (requesfous!=null&&requesfous.isReques()&&"1".equals(requesfous.getTitleTag())){
            titleList2.get(titleFocusTag).requestFocus();
            isShowTitleImg=false;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_DOWN:
//                Log.e("keyDown", "gameActivity: --down---"+keyCode );
                isShowTitleImg=true;
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
//                isSelect=true;
//                Log.e("keyDown", "gameActivity: --up---"+keyCode );
                EventBus.getDefault().post(new TabToMainRequesfous(true,"2"));
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
//                viewPagerTag++;
//                mViewPager.setCurrentItem(viewPagerTag%3);
//                changeTitleFous();
                if (titleFocusTag==titleList2.size()-1){//如果最右侧标题获取焦点  再按向右键  让焦点不再改变
                    return true;
                }
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (b){
            int i= (int) view.getTag();
            Log.e("gameTitle", "onFocusChange: ----"+i );
            liveshow_viewPager.setCurrentItem(i);
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
