package com.dwb.ruyou.tvhall.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.dwb.ruyou.tvhall.R;

/**
 * Created by Slayer on 2017/6/23.
 */

public class MyTextView extends LinearLayout {
    private Context mContext;
    public MyTextView(Context context) {
        super(context);
        this.mContext=context;
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
        initView();
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView() {
        View view= LayoutInflater.from(mContext).inflate(R.layout.mytextview_layout,this);
    }
    
}
