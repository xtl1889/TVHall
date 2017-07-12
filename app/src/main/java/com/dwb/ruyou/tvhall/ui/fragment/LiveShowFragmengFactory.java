package com.dwb.ruyou.tvhall.ui.fragment;

import com.dwb.ruyou.tvhall.ui.base.BaseFragment;

/**
 * Created by Slayer on 2017/6/6.
 */

public class LiveShowFragmengFactory {
    public static <T extends BaseFragment>T getFragmeng(Class<T> c){
        BaseFragment baseFragment=null;
        try {
            baseFragment= (BaseFragment) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) baseFragment;
    }
}
