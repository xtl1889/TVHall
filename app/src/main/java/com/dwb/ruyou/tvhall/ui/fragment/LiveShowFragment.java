package com.dwb.ruyou.tvhall.ui.fragment;

import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.ui.MainActivity;
import com.dwb.ruyou.tvhall.ui.base.BaseFragment;

/**
 * Created by Slayer on 2017/6/15.
 */

public class LiveShowFragment extends BaseFragment {
    private MainActivity parentActivity;
    private TextView liveShowView;
    @Override
    public int getViewId() {
        return R.layout.liveshowlayout_fragment;
    }

    @Override
    public void initView() {
        super.initView();
//        parentActivity= (MainActivity) getActivity();
        liveShowView= (TextView) view.findViewById(R.id.liveShow_tv);
    }

}
