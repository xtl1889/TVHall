package com.dwb.ruyou.tvhall.model;

import com.dwb.ruyou.tvhall.ui.base.BaseFragment;

/**
 * Created by Slayer on 2017/6/21.
 */

public class FragmentModel {
    private String title;
    private BaseFragment baseFragment;

    public FragmentModel(String title, BaseFragment baseFragment) {
        this.title = title;
        this.baseFragment = baseFragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BaseFragment getBaseFragment() {
        return baseFragment;
    }

    public void setBaseFragment(BaseFragment baseFragment) {
        this.baseFragment = baseFragment;
    }
}
