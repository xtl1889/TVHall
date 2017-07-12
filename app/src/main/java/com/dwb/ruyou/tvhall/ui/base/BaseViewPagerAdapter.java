package com.dwb.ruyou.tvhall.ui.base;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dwb.ruyou.tvhall.model.FragmentModel;

import java.util.List;

/**
 * Created by Slayer on 2017/6/14.
 */

public abstract class BaseViewPagerAdapter extends FragmentStatePagerAdapter{

    protected List<FragmentModel> mFragmentList;
    protected Context mConext;

    public BaseViewPagerAdapter(FragmentManager fm, List<FragmentModel> mFragmentList, Context mConext) {
        super(fm);
        this.mFragmentList = mFragmentList;
        this.mConext = mConext;
    }

}
