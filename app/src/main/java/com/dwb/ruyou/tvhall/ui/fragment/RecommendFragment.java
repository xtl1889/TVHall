package com.dwb.ruyou.tvhall.ui.fragment;

import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.ui.MainActivity;
import com.dwb.ruyou.tvhall.ui.base.BaseFragment;

/**
 * Created by Slayer on 2017/6/15.
 */

public class RecommendFragment extends BaseFragment {
    private MainActivity parentActivity;
    private TextView recommenView;
    @Override
    public int getViewId() {
        return R.layout.recommendlayout_fragment;
    }

    @Override
    public void initView() {
        super.initView();
//        parentActivity= (MainActivity) getActivity();
        recommenView= (TextView) view.findViewById(R.id.recommend_tv);
    }

}
