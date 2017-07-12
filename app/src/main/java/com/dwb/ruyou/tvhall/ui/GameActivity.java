package com.dwb.ruyou.tvhall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
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
import com.dwb.ruyou.tvhall.model.GameTitle;
import com.dwb.ruyou.tvhall.model.eventbusmodel.MainToTabRequesfous;
import com.dwb.ruyou.tvhall.model.eventbusmodel.TabToMainRequesfous;
import com.dwb.ruyou.tvhall.ui.adapter.Game_fragment_vp_adapter;
import com.dwb.ruyou.tvhall.ui.base.BaseActivity;
import com.dwb.ruyou.tvhall.ui.fragment.Game_All_Fragment;
import com.dwb.ruyou.tvhall.utils.LogUtil;
import com.dwb.ruyou.tvhall.utils.RetrofitUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameActivity extends BaseActivity implements View.OnClickListener,View.OnFocusChangeListener{

    private String[] sTitle={"全部","王者荣耀","穿越火线"};
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ArrayList<FragmentModel> mFragmentList = new ArrayList<>();
    private Game_fragment_vp_adapter viewPagerAdapter;

    private LinearLayout game_title_layout;
    private List<TextView> titleList2=new ArrayList<>();
    private List<ImageView> titleImageViewList=new ArrayList<>();

    private int titleFocusTag=-1;//当前获取焦点的标题
    private boolean isShowTitleImg;//是否显示标题下的图片

    private TVhallApi tVhallApi;
    private Call<GameTitle> gameTitleCall;
    private GameTitle gameTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        EventBus.getDefault().register(this);
        initView();
    }

    private void initView() {
        tVhallApi= RetrofitUtils.getRestofitApi(ApiConfig.testUrl1,TVhallApi.class);
        gameTitleCall=tVhallApi.getGameTitle();
        mTabLayout= (TabLayout) findViewById(R.id.game_Tablayout);
        mViewPager= (ViewPager) findViewById(R.id.game_viewPager);
        game_title_layout= (LinearLayout) findViewById(R.id.game_title_layout);
        getTitleData();
    }

    private void getTitleData() {
        gameTitleCall.enqueue(new Callback<GameTitle>() {
            @Override
            public void onResponse(Call<GameTitle> call, Response<GameTitle> response) {
                if (response.body()!=null&&"SUCCESS".equals(response.body().getResult())){
                    gameTitle=response.body();
                    addGameTtileView();
                    initFragment();
                }else {
                    Toast.makeText(GameActivity.this,"获取游戏标题失败!",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GameTitle> call, Throwable t) {
                Toast.makeText(GameActivity.this,"无法获取游戏标题!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**利用LinearLayout添加游戏标题*/
    private void addGameTtileView(){
        game_title_layout.removeAllViews();
        int n=gameTitle.getGameTypeList().size();
        for (int i = 0; i < n; i++) {
            View view= LayoutInflater.from(this).inflate(R.layout.game_title_layout,null);
            TextView tv= (TextView) view.findViewById(R.id.game_title_tv);
            ImageView imageView= (ImageView) view.findViewById(R.id.game_title_img);
            tv.setOnFocusChangeListener(this);
            tv.setText(gameTitle.getGameTypeList().get(i));
            tv.setTag(i);
            game_title_layout.addView(view);
            titleList2.add(tv);
            titleImageViewList.add(imageView);
        }
    }


    private void initFragment() {
        mFragmentList.clear();
        FragmentManager fragmentMassager=this.getSupportFragmentManager();
        FragmentTransaction fragmentTran=fragmentMassager.beginTransaction();

        for (int i = 0; i < gameTitle.getGameTypeList().size(); i++) {
            String gameType=gameTitle.getGameTypeList().get(i);
            mFragmentList.add(new FragmentModel(gameTitle.getGameTypeList().get(i),new Game_All_Fragment(gameType)));
        }
        fragmentTran.commitAllowingStateLoss();
        viewPagerAdapter=new Game_fragment_vp_adapter(fragmentMassager,mFragmentList,this);
//        mViewPager.setOffscreenPageLimit(3);//指定ViewPager缓存Fragment的个数
        mViewPager.setAdapter(viewPagerAdapter);
        mViewPager.setCurrentItem(0);//初始页面

        mTabLayout.setupWithViewPager(mViewPager);
        //利用tablayout添加标题
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tabAt=mTabLayout.getTabAt(i);
            tabAt.setCustomView(viewPagerAdapter.getView(i));
//            if (i==0){
//                all_tv_tablayout=(TextView) viewPagerAdapter.getView(i).findViewById(R.id.game_txt_title);
//            }
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (viewPagerAdapter!=null){
            viewPagerAdapter.onKeyDown(keyCode,event);
        }

        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_DOWN:
//                Log.e("keyDown", "------gameActivity: -----down---"+keyCode );
                isShowTitleImg=true;
//                all_tv.requestFocus();
                break;
//                return true;
            case KeyEvent.KEYCODE_DPAD_UP:
//                isSelect=true;
//                Log.e("keyDown", "gameActivity: --up---"+keyCode );
                EventBus.getDefault().post(new TabToMainRequesfous(true,"3"));
//                viewPagerAdapter.titleFocus(-1);
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
//                viewPagerTag--;
//                if (viewPagerTag<0){
//                    viewPagerTag=0;
//                }
//                mViewPager.setCurrentItem(viewPagerTag%3);
//                changeTitleFous();
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
//                viewPagerTag++;
//                mViewPager.setCurrentItem(viewPagerTag%3);
//                changeTitleFous();
                if (titleFocusTag==titleList2.size()-1){//如果最右侧标题获取焦点  再按向右键  让焦点不再改变
                    return true;
                }
                break;
//                return true;
            case KeyEvent.KEYCODE_BACK:
               LogUtil.e("TvRecyclerView", "--g-back---");
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==2&&requestCode==1){
            String s=data.getStringExtra("gameType");
            if (gameTitle.getGameTypeList().contains(s)){
                int i=gameTitle.getGameTypeList().indexOf(s);
//                mViewPager.setCurrentItem(i);
                isShowTitleImg=false;
                LogUtil.e("gameTitle", "onActivityResult: ----");
            }
        }
    }

    /**
     * (当一级页面按向下按钮时  二级级页面标题显示焦点   目前该功能取消)
     * 当item向上按时  标题回复焦点
     * */
    @Subscribe(threadMode = ThreadMode.POSTING) // ThreadMode is optional here
    public void onMessage(MainToTabRequesfous requesfous) {
//        Log.e("enentBus", "onMessage: ---------"+requesfous.getTitleTag() );
        if (requesfous!=null&&requesfous.isReques()&&"2".equals(requesfous.getTitleTag())){
            titleList2.get(titleFocusTag).requestFocus();
            isShowTitleImg=false;
        }
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (b){
            int i= (int) view.getTag();
            LogUtil.e("gameTitle", "onFocusChange: ----"+i );
            mViewPager.setCurrentItem(i);
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
