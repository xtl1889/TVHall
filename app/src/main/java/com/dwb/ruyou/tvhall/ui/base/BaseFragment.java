package com.dwb.ruyou.tvhall.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Slayer on 2017/6/6.
 */

public abstract class BaseFragment extends Fragment{
    protected View view;
    protected Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view==null){
            view=inflater.inflate(getViewId(),container,false);
        }
        mContext=getActivity();
        initView();
        return view;
    }
    public abstract int getViewId();


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    public void initView(){}

}
