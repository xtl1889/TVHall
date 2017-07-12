package com.dwb.ruyou.tvhall.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.dwb.ruyou.tvhall.model.HomeModel;
import com.dwb.ruyou.tvhall.ui.base.BaseVerticalAdapter;
import com.dwb.ruyou.tvhall.ui.widget.RecommendClassiedView;
import com.dwb.ruyou.tvhall.ui.widget.RecommendGameView;
import com.dwb.ruyou.tvhall.ui.widget.RecommendLiveShowView;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvRecyclerView;

/**
 * Created by Slayer on 2017/6/28.
 */

public class RecommendAdapter extends BaseVerticalAdapter<HomeModel> {
    private TvRecyclerView tvRecyclerView;

    public RecommendAdapter(Context mContext) {
        super(mContext);
    }

    public RecommendAdapter(Context mContext, TvRecyclerView tvRecyclerView) {
        super(mContext);
        this.tvRecyclerView = tvRecyclerView;
    }

    @Override
    public int getItemViewType(int position) {
        String tag=getItem(position).getTag();
        if ("liveShow".equals(tag)){
            return 0;
        }else if ("classied".equals(tag)){
            return 1;
        }else if ("game".equals(tag)){
            return 2;
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder=null;
        switch (viewType){
            case 0:
                viewHolder=new RecommendLiveShowViewHolder(new RecommendLiveShowView(mContext));
                break;
            case 1:
                viewHolder=new RecommendClassiedViewHolder(new RecommendClassiedView(mContext));
                break;
            case 2:
                viewHolder=new RecommendGameVewHolder(new RecommendGameView(mContext));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        HomeModel homeModel=getItem(position);
        switch (getItemViewType(position)){
            case 0:
                RecommendLiveShowViewHolder liveShowViewHolder= (RecommendLiveShowViewHolder) holder;
                liveShowViewHolder.liveShowView.addItem(homeModel.getLivingShowRoomList());
                break;
            case 1:
                RecommendClassiedViewHolder classiedViewHolder= (RecommendClassiedViewHolder) holder;
                classiedViewHolder.classiedView.addItem(homeModel.getLivingShowGameList());
                break;
            case 2:
                RecommendGameVewHolder gameVewHolder= (RecommendGameVewHolder) holder;
                gameVewHolder.gameView.addItem(homeModel.getCpGameList());
                break;

        }
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    class RecommendLiveShowViewHolder extends RecyclerView.ViewHolder{
        RecommendLiveShowView liveShowView;
        public RecommendLiveShowViewHolder(RecommendLiveShowView itemView) {
            super(itemView);
            liveShowView=itemView;
            liveShowView.setFocusable(true);
        }
    }

    class RecommendClassiedViewHolder extends RecyclerView.ViewHolder{
        RecommendClassiedView classiedView;
        public RecommendClassiedViewHolder(RecommendClassiedView itemView) {
            super(itemView);
            classiedView=itemView;
            classiedView.setFocusable(true);
        }
    }

    class RecommendGameVewHolder extends RecyclerView.ViewHolder{
        RecommendGameView gameView;
        public RecommendGameVewHolder(RecommendGameView itemView) {
            super(itemView);
            gameView=itemView;
            gameView.setFocusable(true);
        }
    }
}
