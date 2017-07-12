package com.dwb.ruyou.tvhall.ui.widget;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.model.LiveShowItemBean;
import com.dwb.ruyou.tvhall.ui.adapter.LiveShowAdapter;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvGridLayoutManager;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvRecyclerView;

import java.util.List;

/**
 * Created by Slayer on 2017/7/7.
 */

public class SearchAllWatchingView extends RelativeLayout {

    private Context mContext;
    private TvRecyclerView mRecyclerView;
    private LiveShowAdapter adapter;
    public SearchAllWatchingView(Context context) {
        super(context);
        this.mContext=context;
        initView();
    }

    private void initView() {
        View view= LayoutInflater.from(mContext).inflate(R.layout.searchall_watching_layout,this);
        mRecyclerView= (TvRecyclerView) view.findViewById(R.id.search_all_watching_rv);
        adapter=new LiveShowAdapter(mContext);
        TvGridLayoutManager tvGridLayoutManager=new TvGridLayoutManager(mContext,3);
        tvGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(tvGridLayoutManager);
        mRecyclerView.setKeyLeftNoItemListener(null,1);
//        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(null);
        mRecyclerView.setAdapter(adapter);
    }
    public void addItem(List<LiveShowItemBean> listItem){
        if (adapter!=null&&listItem!=null){
            adapter.updateItems(listItem);
        }
    }
}
