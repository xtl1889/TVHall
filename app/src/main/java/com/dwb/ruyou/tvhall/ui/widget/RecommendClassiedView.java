package com.dwb.ruyou.tvhall.ui.widget;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.model.RecommendClassiedBean;
import com.dwb.ruyou.tvhall.ui.adapter.RecommendClassiedAdapter;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvGridLayoutManager;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvRecyclerView;

import java.util.List;

/**
 * Created by Slayer on 2017/7/7.
 */

public class RecommendClassiedView extends RelativeLayout {

    private Context mContext;
    private TvRecyclerView mRecyclerView;
    private RecommendClassiedAdapter adapter;
    public RecommendClassiedView(Context context) {
        super(context);
        this.mContext=context;
        initView();
    }

    private void initView() {
        View view= LayoutInflater.from(mContext).inflate(R.layout.recyclerview_layout,this);
        mRecyclerView= (TvRecyclerView) view.findViewById(R.id.recyclerView_layout);
        mRecyclerView.setKeyDownNoItemListener(null,1);
        mRecyclerView.setKeyUpNoItemListener(null,1);
        adapter= new RecommendClassiedAdapter(mContext);
        TvGridLayoutManager tvGridLayoutManager=new TvGridLayoutManager(mContext,5);
        tvGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(tvGridLayoutManager);
        mRecyclerView.setItemAnimator(null);
        mRecyclerView.setAdapter(adapter);
    }
    public void addItem(List<RecommendClassiedBean> listItem){
        if (adapter!=null&&listItem!=null){
            adapter.updateItems(listItem);
        }
    }

    public void getFocus(){
        if (mRecyclerView.getChildAt(0)!=null){
            mRecyclerView.getChildAt(0).requestFocus();
        }
    }
}
