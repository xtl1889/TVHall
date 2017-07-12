package com.dwb.ruyou.tvhall.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.model.FragmentModel;
import com.dwb.ruyou.tvhall.ui.base.BaseViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slayer on 2017/6/14.
 */

public class Game_fragment_vp_adapter extends BaseViewPagerAdapter {
    private List<TextView> textViewList=new ArrayList<>();//导航标题的集合

    public Game_fragment_vp_adapter(FragmentManager fm, List<FragmentModel> mFragmentList, Context mConext) {
        super(fm, mFragmentList, mConext);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position).getBaseFragment();
    }

    @Override
    public int getCount() {
        return mFragmentList!=null?mFragmentList.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }



    public View getView(int i){
        View view=View.inflate(mConext, R.layout.view_tablaout,null);
        TextView tv= (TextView) view.findViewById(R.id.game_txt_title);
//        SimpleDraweeView img= (SimpleDraweeView) view.findViewById(R.id.img_logo);
        tv.setText(mFragmentList.get(i).getTitle());
        textViewList.add(tv);
        return view;
    }

    public void titleFocus(int i){
        for (int j = 0; j < textViewList.size(); j++) {
            if (i==j){
                textViewList.get(j).setTextColor(Color.RED);
                textViewList.get(j).requestFocus();
            }else {
                textViewList.get(j).clearFocus();
                textViewList.get(j).setTextColor(Color.WHITE);
            }
        }
    }

    public void addFragment(List<FragmentModel> gameFragmentModelList){
        if (gameFragmentModelList==null)return;
        this.mFragmentList=gameFragmentModelList;
        notifyDataSetChanged();
    }

    public void onKeyDown(int keyCode, KeyEvent event){
        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_DOWN:
                Log.e("keyDown", "viewpagerAdapter: --down---"+keyCode );
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                Log.e("keyDown", "viewpagerAdapter: --up---"+keyCode );
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                Log.e("keyDown", "viewpagerAdapter: --left---"+keyCode );
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                Log.e("keyDown", "viewpagerAdapter: --right---"+keyCode );
                break;
        }
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        try{
            super.finishUpdate(container);
        } catch (NullPointerException nullPointerException){
            System.out.println("Catch the NullPointerException in FragmentPagerAdapter.finishUpdate");
        }
    }
}
