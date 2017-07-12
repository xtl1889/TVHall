package com.dwb.ruyou.tvhall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.application.TVHallApplication;
import com.dwb.ruyou.tvhall.model.eventbusmodel.PersonFragmentToActivity;
import com.dwb.ruyou.tvhall.ui.base.BaseActivity;
import com.dwb.ruyou.tvhall.ui.base.BaseFragment;
import com.dwb.ruyou.tvhall.ui.fragment.PersonCener_Subscibe_Fragment;
import com.dwb.ruyou.tvhall.ui.fragment.PersonCenter_Gold_Fragment;
import com.dwb.ruyou.tvhall.ui.fragment.PersonCenter_Mygame_Fragment;
import com.dwb.ruyou.tvhall.ui.fragment.PersonalCenter_Looked_Fragment;
import com.dwb.ruyou.tvhall.ui.fragment.PersonalCenter_Setting_Fragment;
import com.dwb.ruyou.tvhall.utils.LogUtil;
import com.dwb.ruyou.tvhall.utils.LogUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class PersonalCenterActivity extends BaseActivity implements View.OnFocusChangeListener{

    private TextView personal_title_tv;
    private TextView already_look_tv,subscibe_tv,my_game_tv,play_glod_tv,setting_tv;
    private ImageView looked_title_select_img,subscibe_title_select_img,game_title_select_img,gold_title_select_img,setting_title_select_img;
    private FrameLayout personal_farmeLayout;

    private FragmentManager fragmentManager;
    private BaseFragment nowShowFragment;//当前显示的fragment
    private List<TextView> titleList=new ArrayList<>();//标题的集合
    private List<ImageView> titleImgList=new ArrayList<>();//标题下标的集合
    private List<BaseFragment> baseFragmentList=new ArrayList<>();//fragment的集合
    private int showFragmentTag=0;
    private boolean isLogin;
    private boolean isFoucus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_center);
        EventBus.getDefault().register(this);
        Intent intent=getIntent();
        if (intent!=null){
            showFragmentTag=intent.getIntExtra("showFragmentTag",0);
        }
        LogUtils.LOGD("personalCenter---------"+showFragmentTag);
        initView();
    }

    private void initView() {
        isLogin= TVHallApplication.isLogin;
        fragmentManager=getSupportFragmentManager();

        personal_title_tv= (TextView) findViewById(R.id.personal_title);
        TextPaint tp = personal_title_tv .getPaint();
        tp.setFakeBoldText(true);

        already_look_tv= (TextView) findViewById(R.id.already_look_tv);
        already_look_tv.setOnFocusChangeListener(this);
        subscibe_tv= (TextView) findViewById(R.id.subscibe_tv);
        subscibe_tv.setOnFocusChangeListener(this);
        my_game_tv= (TextView) findViewById(R.id.my_game_tv);
        my_game_tv.setOnFocusChangeListener(this);
        play_glod_tv= (TextView) findViewById(R.id.play_glod_tv);
        play_glod_tv.setOnFocusChangeListener(this);
        setting_tv= (TextView) findViewById(R.id.setting_tv);
        setting_tv.setOnFocusChangeListener(this);
        looked_title_select_img= (ImageView) findViewById(R.id.looked_title_select_img);
        subscibe_title_select_img= (ImageView) findViewById(R.id.subscibe_title_select_img);
        game_title_select_img= (ImageView) findViewById(R.id.game_title_select_img);
        gold_title_select_img= (ImageView) findViewById(R.id.gold_title_select_img);
        setting_title_select_img= (ImageView) findViewById(R.id.setting_title_select_img);
        titleList.add(already_look_tv);
        titleList.add(subscibe_tv);
        titleList.add(my_game_tv);
        titleList.add(play_glod_tv);
        titleList.add(setting_tv);
        titleImgList.add(looked_title_select_img);
        titleImgList.add(subscibe_title_select_img);
        titleImgList.add(game_title_select_img);
        titleImgList.add(gold_title_select_img);
        titleImgList.add(setting_title_select_img);
        personal_farmeLayout= (FrameLayout) findViewById(R.id.personal_farmeLayout);

        baseFragmentList.add(new PersonalCenter_Looked_Fragment());
        baseFragmentList.add(new PersonCener_Subscibe_Fragment());
        baseFragmentList.add(new PersonCenter_Mygame_Fragment());
        baseFragmentList.add(new PersonCenter_Gold_Fragment());
        baseFragmentList.add(new PersonalCenter_Setting_Fragment());
//        fragmentManager.beginTransaction().add(R.id.personal_farmeLayout,baseFragmentList.get(0)).commit();

        if (isLogin){
            play_glod_tv.setNextFocusRightId(R.id.gold_changeuser_tv);
        }else {
            play_glod_tv.setNextFocusRightId(R.id.playGold_phoneNum_et);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        setSelectTitle();
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()){
            case R.id.already_look_tv:
                if (b){
                    showFragmentTag=0;
//                    hideTitleImg();
                }else {
                    if (showFragmentTag==0){
                        looked_title_select_img.setVisibility(View.VISIBLE);
                    }
                }
                break;
            case R.id.subscibe_tv:
                if (b){
                    showFragmentTag=1;
//                    hideTitleImg();
                }else {
                    if (showFragmentTag==1){
                        subscibe_title_select_img.setVisibility(View.VISIBLE);
                    }
                }
                break;
            case R.id.my_game_tv:
                if (b){
                    showFragmentTag=2;
//                    hideTitleImg();
                }else {
                    if (showFragmentTag==2){
                        game_title_select_img.setVisibility(View.VISIBLE);
                    }
                }
                break;
            case R.id.play_glod_tv:
                if (b){
                    showFragmentTag=3;
//                    hideTitleImg();
                }else {
                    if (showFragmentTag==3){
                        gold_title_select_img.setVisibility(View.VISIBLE);
                    }
                }
                break;
            case R.id.setting_tv:
                if (b){
                    showFragmentTag=4;
//                    hideTitleImg();
                }else {
                    if (showFragmentTag==4){
                        setting_title_select_img.setVisibility(View.VISIBLE);
                    }
                }
                break;
        }
        LogUtil.e("setting","---showFragmentTag-----"+showFragmentTag+"----b---"+b);
        if (b){
            changeFragment(showFragmentTag);
            hideTitleImg();
        }
    }

    private void hideTitleImg(){
        for (int i = 0; i < titleImgList.size(); i++) {
            if (titleImgList.get(i).getVisibility()==View.VISIBLE){
                titleImgList.get(i).setVisibility(View.INVISIBLE);
            }
        }
    }
    /**
     * 当fragment按向左键时  标题恢复焦点
     * */
    @Subscribe(threadMode = ThreadMode.POSTING) // ThreadMode is optional here
    public void onMessage(PersonFragmentToActivity fragmentToActivity) {
        if (fragmentToActivity!=null&&fragmentToActivity.isReques()){
//            Log.e("person", "-activity-onMessage: ----"+fragmentToActivity.toString() );
            int i=fragmentToActivity.getFragmentTag();
            if (i<titleList.size()){
                titleList.get(i).requestFocus();
            }
        }
    }

    private void changeFragment(int i){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        //判断当前的Fragment是否为空，不为空则隐藏
        if (nowShowFragment!=null){
            ft.hide(nowShowFragment);
        }
        //先根据Tag从FragmentTransaction事物获取之前添加的Fragment
        Fragment fragment=fragmentManager.findFragmentByTag(baseFragmentList.get(i).getClass().getName());
        if (null==fragment){
            fragment=baseFragmentList.get(i);
        }
        nowShowFragment= (BaseFragment) fragment;

        if (!fragment.isAdded()){
            ft.add(R.id.personal_farmeLayout,fragment,fragment.getClass().getName());
//            ft.addToBackStack(null);
        }else {
            ft.show(fragment);
        }
//        Log.e("personalCenter", "activity is finsh: ------"+this.isFinishing() );
//        ft.commit();
        if (!this.isFinishing()){
        ft.commitAllowingStateLoss();
        }
    }

    private void setSelectTitle(){
        if (showFragmentTag!=0){
            switch (showFragmentTag){
                case 1:
                    subscibe_tv.requestFocus();
                    break;
                case 2:
                    my_game_tv.requestFocus();
                    break;
                case 3:
                    play_glod_tv.requestFocus();
                    break;
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_DOWN:
                LogUtil.e("personal","-----down-----");
                break;
            case KeyEvent.KEYCODE_BACK:
//                LogUtil.e("personal","-----back-----");
                finish();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
