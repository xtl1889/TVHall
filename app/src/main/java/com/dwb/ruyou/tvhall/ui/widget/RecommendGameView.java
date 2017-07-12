package com.dwb.ruyou.tvhall.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

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

public class RecommendGameView extends RelativeLayout {

    private Context mContext;
    private TvRecyclerView mRecyclerView;
    private Game_all_adapter adapter;
    public RecommendGameView(Context context) {
        super(context);
        this.mContext=context;
        initView();
    }

    Game_all_adapter.ClickItmeListener clickItmeListener=new Game_all_adapter.ClickItmeListener() {
        @Override
        public void clickItem(View view, int pos, String appKey,String gameType) {
            Intent intent=new Intent(mContext, GameDetailActivity.class);
            intent.putExtra("appKey",appKey);
            intent.putExtra("gameType",gameType);
            mContext.startActivity(intent);
        }
    };

    private void initView() {
        View view= LayoutInflater.from(mContext).inflate(R.layout.recyclerview_layout,this);
        mRecyclerView= (TvRecyclerView) view.findViewById(R.id.recyclerView_layout);
        mRecyclerView.setKeyUpNoItemListener(null,1);
        adapter=new Game_all_adapter(mContext);
        TvGridLayoutManager tvGridLayoutManager=new TvGridLayoutManager(mContext,5);
        tvGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(tvGridLayoutManager);
        mRecyclerView.setItemAnimator(null);
        mRecyclerView.setAdapter(adapter);
        if (adapter!=null){
            adapter.setClickItemListener(clickItmeListener);
        }
    }
    public void addItem(List<GameItemBean> listItem){
        if (adapter!=null&&listItem!=null){
            adapter.updateItems(listItem);
        }
    }
}
