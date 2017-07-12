package com.dwb.ruyou.tvhall.ui.fragment;

import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.ui.MainActivity;
import com.dwb.ruyou.tvhall.ui.base.BaseFragment;

/**
 * Created by Slayer on 2017/6/15.
 */

public class ClassfiedFragment extends BaseFragment {
    private MainActivity parentActivity;
    private TextView classliedView;
    @Override
    public int getViewId() {
        return R.layout.classfiedlayout_fragment;
    }

    @Override
    public void initView() {
        super.initView();
//        parentActivity= (MainActivity) getActivity();
        classliedView= (TextView) view.findViewById(R.id.classified_tv);
    }
}
