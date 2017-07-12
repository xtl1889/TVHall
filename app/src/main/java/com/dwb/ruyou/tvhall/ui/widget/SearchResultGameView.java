package com.dwb.ruyou.tvhall.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.model.GameItemBean;
import com.dwb.ruyou.tvhall.ui.GameDetailActivity;
import com.dwb.ruyou.tvhall.ui.adapter.Game_all_adapter;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvGridLayoutManager;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvRecyclerView;

import java.util.List;

/**
 * Created by Slayer on 2017/7/7.
 */

public class SearchResultGameView extends RelativeLayout {

    private Context mContext;
    private TvRecyclerView mRecyclerView;
    private TextView textView;
    private Game_all_adapter adapter;
    public SearchResultGameView(Context context) {
        super(context);
        this.mContext=context;
        initView();
    }

    private void initView() {
        View view= LayoutInflater.from(mContext).inflate(R.layout.searchall_result_layout,this);
        mRecyclerView= (TvRecyclerView) view.findViewById(R.id.search_result_rv);
        mRecyclerView.setKeyDownNoItemListener(null,1);
        mRecyclerView.setKeyLeftNoItemListener(null,1);
        textView= (TextView) view.findViewById(R.id.search_result_tv);
        adapter=new Game_all_adapter(mContext);
        adapter.setClickItemListener(clickItmeListener);
        TvGridLayoutManager tvGridLayoutManager=new TvGridLayoutManager(mContext,3);
        tvGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(tvGridLayoutManager);
//        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(null);
        mRecyclerView.setAdapter(adapter);
    }
    public void addItem(List<GameItemBean> listItem){
        if (adapter!=null&&listItem!=null){
            adapter.updateItems(listItem);
        }
        textView.setText("游戏");
    }

    Game_all_adapter.ClickItmeListener clickItmeListener=new Game_all_adapter.ClickItmeListener() {
        @Override
        public void clickItem(View view, int pos, String appKey, String gameType) {
            Intent intent=new Intent(mContext, GameDetailActivity.class);
            intent.putExtra("appKey",appKey);
            intent.putExtra("gameType",gameType);
            mContext.startActivity(intent);
        }
    };
}
