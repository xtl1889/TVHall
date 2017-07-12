package com.dwb.ruyou.tvhall.ui.adapter;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dwb.ruyou.tvhall.ui.base.BaseFragment2;

import java.util.ArrayList;

/**
 * Main UI Adapter
 *
 * @author jacky
 * @version v1.0
 * @since 2016.4.1
 */
public class GameViewPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<BaseFragment2> mFragments;
    private FragmentManager fm;

    public GameViewPagerAdapter(FragmentManager fm, ArrayList<BaseFragment2> fragments) {
        super(fm);
        mFragments = fragments;
        this.fm = fm;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

}
