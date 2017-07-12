package com.dwb.ruyou.tvhall.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.model.FragmentModel;
import com.dwb.ruyou.tvhall.model.eventbusmodel.MainToTabRequesfous;
import com.dwb.ruyou.tvhall.ui.adapter.Game_fragment_vp_adapter;
import com.dwb.ruyou.tvhall.ui.base.BaseFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slayer on 2017/6/15.
 */

public class GameFragment extends BaseFragment implements View.OnFocusChangeListener{

    private Context mContext;
    private TextView all_tv,wangze_tv,huoxian_tv;
    private FrameLayout frameLayout;
    private BaseFragment allFragment,wangzheFragmeng,huoxianFragment;
    private FragmentManager fm;


    private boolean isSelect;
    private List<TextView> textViewList=new ArrayList<>();
    private int focusTag=-1;


    private String[] sTitle={"全部","王者荣耀","穿越火线"};
    private TabLayout tableLayout;
    private ViewPager mViewPager;
    private Game_fragment_vp_adapter viewPagerAdapter;
    private ArrayList<FragmentModel> mFragmentList = new ArrayList<>();
    private TextView all_tv_tablayout;

    @Override
    public int getViewId() {
        return R.layout.gamelayout_fragment;
    }

    /**利用textview fragment加载数据*/
    public void initView() {
        mContext=getActivity();
        frameLayout= (FrameLayout) view.findViewById(R.id.game_frameLayout);
        all_tv= (TextView) view.findViewById(R.id.game_fragment_title_all);
        all_tv.setOnFocusChangeListener(this);
        wangze_tv= (TextView) view.findViewById(R.id.game_fragment_title_wangzhe);
        wangze_tv.setOnFocusChangeListener(this);
        huoxian_tv= (TextView) view.findViewById(R.id.game_fragment_title_huoxian);
        huoxian_tv.setOnFocusChangeListener(this);

        textViewList.add(all_tv);
        textViewList.add(wangze_tv);
        textViewList.add(huoxian_tv);

        fm=getChildFragmentManager();
        allFragment=new Game_All_Fragment(all_tv);
        fm.beginTransaction().add(R.id.game_frameLayout,allFragment).commit();

        initFragment();
    }


/**利用tablayout viewpager加载主机*/
    private void initFragment() {
        tableLayout= (TabLayout) view.findViewById(R.id.game_fragment_Tablayout);
        mViewPager= (ViewPager) view.findViewById(R.id.game_fragment_viewPager);

        mFragmentList.clear();
        FragmentManager fragmentMassager=getChildFragmentManager();
        FragmentTransaction fragmentTran=fragmentMassager.beginTransaction();

        LiveShow_All_Fragment all_fragment=new LiveShow_All_Fragment();
        LiveShow_Huoxian_Fragment huoxian_fagment=new LiveShow_Huoxian_Fragment();
        LiveShow_Wangze_Fragment wangze_fangment=new LiveShow_Wangze_Fragment();


        mFragmentList.add(new FragmentModel(sTitle[0],new Game_All_Fragment()));
        mFragmentList.add(new FragmentModel(sTitle[1],new Game_All_Fragment()));
        mFragmentList.add(new FragmentModel(sTitle[2],new Game_All_Fragment()));

        fragmentTran.commitAllowingStateLoss();
        viewPagerAdapter=new Game_fragment_vp_adapter(fragmentMassager,mFragmentList,mContext);
//        mViewPager.setOffscreenPageLimit(3);//指定ViewPager缓存Fragment的个数
        mViewPager.setAdapter(viewPagerAdapter);
        mViewPager.setCurrentItem(0);//初始页面

        tableLayout.setupWithViewPager(mViewPager);
        for (int i = 0; i < tableLayout.getTabCount(); i++) {
            TabLayout.Tab tabAt=tableLayout.getTabAt(i);
            tabAt.setCustomView(viewPagerAdapter.getView(i));
//            if (i==0){
//                all_tv_tablayout=(TextView) viewPagerAdapter.getView(i).findViewById(R.id.game_txt_title);
//            }
        }
    }

    private void selectTtile(int i){
        for (int j = 0; j < textViewList.size(); j++) {
            if (i==j){
                textViewList.get(j).setTextColor(Color.RED);
            }else {
                textViewList.get(j).setTextColor(getResources().getColor(R.color.text_white));
            }
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event){
        Log.e("keyDown", "onKeyDown: ---f--"+keyCode );
                switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_DOWN:
//                selectTtile(focusTag);
                viewPagerAdapter.titleFocus(0);
                Log.e("keyDown", "onKeyDown: ---f-down---"+keyCode );
                break;
            case KeyEvent.KEYCODE_DPAD_UP://当按向上键时  做一个标记  恢复标题获取焦点后的字体颜色
                isSelect=true;
                Log.e("keyDown", "onKeyDown: ---f-up---"+keyCode );
                break;
        }
        return false;
    }
    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()){
            case R.id.game_fragment_title_all:
                if (allFragment==null){
                    allFragment= new Game_All_Fragment();
                }
                fm.beginTransaction().replace(R.id.game_frameLayout,allFragment).commit();
                focusTag=0;
                if (isSelect){
                    all_tv.setTextColor(getResources().getColor(R.color.text_white));
                }
                break;
            case R.id.game_fragment_title_wangzhe:
                if (wangzheFragmeng==null){
                    wangzheFragmeng= new LiveShow_Wangze_Fragment();
                }
                fm.beginTransaction().replace(R.id.game_frameLayout,wangzheFragmeng).commit();
                focusTag=1;
                if (isSelect){
                    wangze_tv.setTextColor(getResources().getColor(R.color.text_white));
                }
                break;
            case R.id.game_fragment_title_huoxian:
                if (huoxianFragment==null){
                    huoxianFragment= new LiveShow_Huoxian_Fragment();
                }
                fm.beginTransaction().replace(R.id.game_frameLayout,huoxianFragment).commit();
                focusTag=2;
                if (isSelect){
                    huoxian_tv.setTextColor(getResources().getColor(R.color.text_white));
                }
                break;
        }
        isSelect=false;
    }


    @Subscribe(threadMode = ThreadMode.POSTING) // ThreadMode is optional here
    public void onMessage(MainToTabRequesfous requesfous) {
        Log.e("keyDown", "onMessage: -----gameFragment-----"+requesfous.toString() );
        if (requesfous!=null&&requesfous.isReques()&&"2".equals(requesfous.getTitleTag())){
            viewPagerAdapter.titleFocus(0);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
