package com.dwb.ruyou.tvhall.ui;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.model.eventbusmodel.ClickRecommendItem;
import com.dwb.ruyou.tvhall.model.eventbusmodel.TabToMainRequesfous;
import com.dwb.ruyou.tvhall.ui.base.BaseFragment;
import com.dwb.ruyou.tvhall.ui.fragment.ClassfiedFragment;
import com.dwb.ruyou.tvhall.ui.fragment.GameFragment;
import com.dwb.ruyou.tvhall.ui.fragment.LiveShowFragment;
import com.dwb.ruyou.tvhall.ui.fragment.RecommendFragment;
import com.dwb.ruyou.tvhall.utils.LogUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends TabActivity implements View.OnFocusChangeListener,
        View.OnClickListener,TabHost.OnTabChangeListener{
/**------------利用tabLayout导航---------------------*/
    private TabHost host;
    private TabWidget widget;

    private TabHost.TabSpec tab1,tab2,tab3,tab4,tab5;
    private LinearLayout tabLayout1,tabLayout2,tabLayout3,tabLayout4;
    private TextView tab1_tv,tab2_tv,tab3_tv,tab4_tv;
    private ImageView tab1_img,tab2_img,tab3_img,tab4_img;


    private View view1,view2,view3,view4,view5;
    private LayoutInflater inflater;
    private boolean isTab1Reques;//tab 标题的分类获取焦点标记 （推荐有时候无法获取焦点，这里做标记 特殊处理）
    private boolean isTab4Reques;//tab 标题的分类获取焦点标记 （推荐有时候无法获取焦点，这里做标记 特殊处理）
    private int tabTag=-1;//tab标题 获取焦点的标记


    private TextView serchTv,perposeTv,wifiTv;
    private boolean isSelect;// 选中当前标题下的 选项
    private int titleTag=-1;//选中的标题

    /**--------------l利用fragment导航---------------------*/
    private TextView recommend_title_tv,liveshow_title_tv,game_title_tv,classified_title_tv;
    private ImageView recommend_img,liveshow_img,game_img,classsfied_img;
    private BaseFragment nowShowFragment;//当前显示的fragment
    private BaseFragment recommedFragment,liveShowFragment,gameFragment,classifiedFragment;
    private List<BaseFragment> baseFragmentList=new ArrayList<>();
    private FrameLayout frameLayout;

    private int titleNun=0;
    private FragmentManager fm;
    private List<LinearLayout> tabLayoutList=new ArrayList<>();
    private List<TextView> textViewList=new ArrayList<>();
    private List<ImageView> imageViewList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_main);

        tabwidgetTab();
        initView();

//        initView2();
    }

    private void initView() {
        serchTv= (TextView) findViewById(R.id.search_tv);
        serchTv.setOnClickListener(this);
        serchTv.setOnFocusChangeListener(this);
        perposeTv= (TextView) findViewById(R.id.perple_tv);
        perposeTv.setOnClickListener(this);
        perposeTv.setOnFocusChangeListener(this);
        wifiTv= (TextView) findViewById(R.id.wifi_tv);
        wifiTv.setOnClickListener(this);
        wifiTv.setOnFocusChangeListener(this);
    }


    private void initView2() {
        serchTv= (TextView) findViewById(R.id.search_tv);
        serchTv.setOnClickListener(this);
        perposeTv= (TextView) findViewById(R.id.perple_tv);
        perposeTv.setOnClickListener(this);
        wifiTv= (TextView) findViewById(R.id.wifi_tv);
        wifiTv.setOnClickListener(this);

//        fm=getSupportFragmentManager();
        frameLayout= (FrameLayout) findViewById(R.id.main_fragmentLayout);

        recommend_title_tv= (TextView) findViewById(R.id.recommend_title_tv);
        recommend_title_tv.setOnFocusChangeListener(this);
        liveshow_title_tv= (TextView) findViewById(R.id.liveshow_title_tv);
        liveshow_title_tv.setOnFocusChangeListener(this);
        game_title_tv= (TextView) findViewById(R.id.game_title_tv);
        game_title_tv.setOnFocusChangeListener(this);
        classified_title_tv= (TextView) findViewById(R.id.classified_title_tv);
        classified_title_tv.setOnFocusChangeListener(this);

        recommend_img= (ImageView) findViewById(R.id.recommend_select_img);
        liveshow_img= (ImageView) findViewById(R.id.livdshow_select_img);
        game_img= (ImageView) findViewById(R.id.game_select_img);
        classsfied_img= (ImageView) findViewById(R.id.classfied_select_img);

        textViewList.add(recommend_title_tv);
        textViewList.add(liveshow_title_tv);
        textViewList.add(game_title_tv);
        textViewList.add(classified_title_tv);

        baseFragmentList.add(new RecommendFragment());
        baseFragmentList.add(new LiveShowFragment());
        baseFragmentList.add(new GameFragment());
        baseFragmentList.add(new ClassfiedFragment());

//        changeFragment(0);
//        recommedFragment=new RecommendFragment();
//        fm.beginTransaction().add(R.id.main_fragmentLayout,recommedFragment).commit();

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_DOWN:
                if (serchTv.hasFocus()||perposeTv.hasFocus())return true;
                if (!isSelect){
                    isSelect=true;
                    selectTtile(tabTag);
                }
                break;
//                return true;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (tabTag==0){//当焦点在最左侧时  按向左键不在响应
                   return true;
                }
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                LogUtils.LOGD("mainActivity--------"+"right");
                if (tabTag==3){
                    tabTag=-1;
                }
                break;
            case KeyEvent.KEYCODE_ENTER:
                LogUtils.LOGD("mainActivity--------"+"enter");
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    /**
     * 当二级页面按向上按钮时  一级页面标题及时恢复焦点
     * */
    @Subscribe(threadMode = ThreadMode.POSTING) // ThreadMode is optional here
    public void onMessage(TabToMainRequesfous requesfous) {
        if (requesfous!=null&&requesfous.isReques()){
            requestTabFocus(tabTag);
        }
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onMessage(ClickRecommendItem clickRecommendItem) {
      if (clickRecommendItem!=null){
          if (2==clickRecommendItem.getId()){
              requestTabFocus(3);
          }
      }
    }

    private void tabwidgetTab(){
        inflater=LayoutInflater.from(this);
        host=this.getTabHost();
        host.setOnTabChangedListener(this);
        widget=host.getTabWidget();

        tab1=host.newTabSpec("tab1");//创建选项卡其中的参数不是固定的，只是一个标志
        startActivity(R.layout.tab1,tab1, view1,RecommendActivity.class);

        tab2=host.newTabSpec("tab2");
        startActivity(R.layout.tab2,tab2,view2,LiveShowActivity.class);

        tab3=host.newTabSpec("tab3");
        startActivity(R.layout.tab3,tab3,view3,GameActivity.class);

        tab4=host.newTabSpec("tab4");
        startActivity(R.layout.tab4, tab4, view4,ClassifiedActivity.class);

        saveTabLayoutObj();
    }

    private void startActivity(int resource,TabHost.TabSpec tab,View view,Class l) {
        view=inflater.inflate(resource, null);
        tab.setIndicator(view); //设置标题
        Intent intent=new Intent(this, l);
        tab.setContent(intent); //这是跳转内容
        host.addTab(tab); //添加到host中
    }

    private void saveTabLayoutObj(){
        tabLayout1= (LinearLayout) widget.getChildTabViewAt(0).findViewById(R.id.recommend_linear);
        tabLayout1.setOnFocusChangeListener(this);
        tab1_tv= (TextView) widget.getChildTabViewAt(0).findViewById(R.id.tab1_tv);
        tab1_img= (ImageView) widget.getChildTabViewAt(0).findViewById(R.id.tab1_select_img);
        tabLayoutList.add(tabLayout1);
        textViewList.add(tab1_tv);
        imageViewList.add(tab1_img);

        tabLayout2= (LinearLayout) widget.getChildTabViewAt(1).findViewById(R.id.liveshow_linear);
        tabLayout2.setOnFocusChangeListener(this);
        tab2_tv= (TextView) widget.getChildTabViewAt(1).findViewById(R.id.tab2_tv);
        tab2_img= (ImageView) widget.getChildTabViewAt(1).findViewById(R.id.tab2_select_img);
        tabLayoutList.add(tabLayout2);
        textViewList.add(tab2_tv);
        imageViewList.add(tab2_img);

        tabLayout3= (LinearLayout) widget.getChildTabViewAt(2).findViewById(R.id.game_linear);
        tabLayout3.setOnFocusChangeListener(this);
        tab3_tv= (TextView) widget.getChildTabViewAt(2).findViewById(R.id.tab3_tv);
        tab3_img= (ImageView) widget.getChildTabViewAt(2).findViewById(R.id.tab3_select_img);
        tabLayoutList.add(tabLayout3);
        textViewList.add(tab3_tv);
        imageViewList.add(tab3_img);

        tabLayout4= (LinearLayout) widget.getChildTabViewAt(3).findViewById(R.id.classified_linear);
        tabLayout4.setOnFocusChangeListener(this);
        tab4_tv= (TextView) widget.getChildTabViewAt(3).findViewById(R.id.tab4_tv);
        tab4_img= (ImageView) widget.getChildTabViewAt(3).findViewById(R.id.tab4_select_img);
        tabLayoutList.add(tabLayout4);
        textViewList.add(tab4_tv);
        imageViewList.add(tab4_img);
    }


    @Override
    public void onTabChanged(String s) {
//        Log.e("fous", "onTabChanged: ---s--="+s );
        tabTag=-1;
        if ("tab1".equals(s)){
            tabTag=0;
        }else if ("tab2".equals(s)){
            tabTag=1;
        }else if ("tab3".equals(s)){
            tabTag=2;
        }else if ("tab4".equals(s)){
            tabTag=3;
        }
    }


    //当选中标题后  按向下键  给一个选中的标记
    private void selectTtile(int i){
        for (int j = 0; j < tabLayoutList.size(); j++) {
            if (i==j){
                tabLayoutList.get(j).setSelected(false);
                imageViewList.get(j).setVisibility(View.VISIBLE);
            }
        }
    }

    //标题恢复焦点
    private void requestTabFocus(int i){
        for (int j = 0; j < tabLayoutList.size(); j++) {
            isSelect=false;
            imageViewList.get(j).setVisibility(View.INVISIBLE);
            if (i==j){
//                tabLayoutList.get(j).setSelected(true);
                tabLayoutList.get(j).requestFocus();
            }
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
//        tabTag=-1;
        switch (view.getId()){
            case R.id.recommend_linear:
//                Log.e("fous", "onFocusChange: ---recommend--="+view.getId()+"----b---"+b);
                if (b){
                    tabLayout1.setSelected(true);
                    host.setCurrentTabByTag("tab1");
                    tabTag=0;
                }else {
                    tabLayout1.setSelected(false);
                }
                break;
            case R.id.liveshow_linear:
//                Log.e("fous", "onFocusChange: ---livehow--="+view.getId()+"----b---"+b);
                if (b){
                    tabLayout2.setSelected(true);
                    host.setCurrentTabByTag("tab2");
                    tabTag=1;
                }else {
                    tabLayout2.setSelected(false);
                }
                break;
            case R.id.game_linear:
//                Log.e("fous", "onFocusChange: ---game--="+view.getId()+"----b---"+b);
                if (b){
                    tabLayout3.setSelected(true);
                    host.setCurrentTabByTag("tab3");
                    tabTag=2;
                }else {
                    tabLayout3.setSelected(false);
                }
                break;
            case R.id.classified_linear:
//                Log.e("fous", "onFocusChange: ---class--="+view.getId()+"----b---"+b);
                if (b){
                    tabLayout4.setSelected(true);
                    host.setCurrentTabByTag("tab4");
                    tabTag=3;
                }else {
                    tabLayout4.setSelected(false);
                }
                break;
            case R.id.search_tv:
//                Log.e("fous", "onFocusChange: ---search_tv------="+b);
                break;
            case R.id.perple_tv:
//                Log.e("fous", "onFocusChange: ---perple_tv------="+b);
                break;
        }

    }



    private void changeFragment(int i){
//       this.titleNun=i;
        FragmentTransaction ft=fm.beginTransaction();
        //判断当前的Fragment是否为空，不为空则隐藏
        ft.addToBackStack(null);
        if (nowShowFragment!=null){
            ft.hide(nowShowFragment);
        }
        //先根据Tag从FragmentTransaction事物获取之前添加的Fragment
        Fragment fragment=fm.findFragmentByTag(baseFragmentList.get(i).getClass().getName());
        if (null==fragment){
            fragment=baseFragmentList.get(i);
        }
        nowShowFragment= (BaseFragment) fragment;

        if (!fragment.isAdded()){
            ft.add(R.id.main_fragmentLayout,fragment,fragment.getClass().getName());
        }else {
            ft.show(fragment);
        }
        ft.commit();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.search_tv:
                startActivity(new Intent(this,SearchActivity.class));
                break;
            case R.id.perple_tv:
                startActivity(new Intent(this,PersonalCenterActivity.class));
                break;
            case R.id.wifi_tv:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
