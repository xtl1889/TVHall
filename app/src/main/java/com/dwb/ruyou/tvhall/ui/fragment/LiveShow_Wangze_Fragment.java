package com.dwb.ruyou.tvhall.ui.fragment;


import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.ui.base.BaseFragment2;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveShow_Wangze_Fragment extends BaseFragment2 {

//    private GameActivity mParentActivity;
    private TextView tv;
    public LiveShow_Wangze_Fragment() {
        // Required empty public constructor
//        mParentActivity= (GameActivity) getActivity();
    }

    @Override
    public void initView() {
        super.initView();
        tv= (TextView) view.findViewById(R.id.liveShow_wangze_tv);
    }


    @Override
    public int getViewId() {
        return R.layout.fragment_live_show__wangze_;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_UP://按向上按钮时 标题栏获取焦点
//                mParentActivity.requestTabFocus();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
