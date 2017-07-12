package com.dwb.ruyou.tvhall.ui.widget;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.model.LiveShowItemBean;
import com.dwb.ruyou.tvhall.ui.adapter.LiveShowAdapter;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvGridLayoutManager;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvRecyclerView;

import java.util.List;

/**
 * Created by Slayer on 2017/7/7.
 */

public class SearchResultLiveShowView extends RelativeLayout {

    private Context mContext;
    private TvRecyclerView mRecyclerView;
    private TextView textView;
    private LiveShowAdapter adapter;
    public SearchResultLiveShowView(Context context) {
        super(context);
        this.mContext=context;
        initView();
    }

    private void initView() {
        View view= LayoutInflater.from(mContext).inflate(R.layout.searchall_result_layout,this);
        mRecyclerView= (TvRecyclerView) view.findViewById(R.id.search_result_rv);
        mRecyclerView.setKeyUpNoItemListener(null,1);
        mRecyclerView.setKeyLeftNoItemListener(null,1);
        textView= (TextView) view.findViewById(R.id.search_result_tv);
        adapter=new LiveShowAdapter(mContext);
        TvGridLayoutManager tvGridLayoutManager=new TvGridLayoutManager(mContext,3);
        tvGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(tvGridLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);
    }
    public void addItem(List<LiveShowItemBean> listItem){
        textView.setText("直播");
        if (adapter!=null&&listItem!=null){
            adapter.updateItems(listItem);
        }
    }
}
