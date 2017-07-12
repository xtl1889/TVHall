package com.dwb.ruyou.tvhall.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.dwb.ruyou.tvhall.model.SearchResultModel;
import com.dwb.ruyou.tvhall.ui.base.BaseVerticalAdapter;
import com.dwb.ruyou.tvhall.ui.widget.SearchAllWatchingView;
import com.dwb.ruyou.tvhall.ui.widget.SearchNothingView;
import com.dwb.ruyou.tvhall.ui.widget.SearchResultGameView;
import com.dwb.ruyou.tvhall.ui.widget.SearchResultLiveShowView;

/**
 * Created by Slayer on 2017/7/7.
 */

public class SearchAdapter extends BaseVerticalAdapter<SearchResultModel> {
    public SearchAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        String tag=mItemList.get(position).getTag();
        if ("all".equals(tag)){//大家都在看
            return 0;
        }else if ("game".equals(tag)){
            return 1;
        }else if ("liveShow".equals(tag)){
            return 2;
        }else if ("nothing".equals(tag)){
            return 3;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType){
            case 0:
                viewHolder=new AllViewholder(new SearchAllWatchingView(mContext));
                break;
            case 1:
                viewHolder=new GameViewholder(new SearchResultGameView(mContext));
                break;
            case 2:
                viewHolder=new LiveShowViewholder(new SearchResultLiveShowView(mContext));
                break;
            case 3:
                viewHolder=new NothingViewholder(new SearchNothingView(mContext));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SearchResultModel resultModel=mItemList.get(position);
        switch (getItemViewType(position)){
            case 0:
                AllViewholder allViewHolder= (AllViewholder) holder;
                allViewHolder.allWatchingView.addItem(resultModel.getLivingShowRoomList());
                break;
            case 1:
                GameViewholder gameViewHolder= (GameViewholder) holder;
                gameViewHolder.gameView.addItem(resultModel.getCpGameList());
                break;
            case 2:
                LiveShowViewholder liveShowViewHolder= (LiveShowViewholder) holder;
                liveShowViewHolder.liveShowView.addItem(resultModel.getLivingShowRoomList());
                break;
            case 3:
                NothingViewholder nothingViewHolder= (NothingViewholder) holder;
                nothingViewHolder.nothingView.addItem(resultModel.getLivingShowRoomList());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mItemList==null?0:mItemList.size();
    }


    class AllViewholder extends RecyclerView.ViewHolder{
        public SearchAllWatchingView allWatchingView;
        public AllViewholder(SearchAllWatchingView itemView) {
            super(itemView);
            allWatchingView=itemView;
        }
    }

    class GameViewholder extends RecyclerView.ViewHolder{
        public SearchResultGameView gameView;
        public GameViewholder(SearchResultGameView itemView) {
            super(itemView);
            gameView=itemView;
        }
    }

    class LiveShowViewholder extends RecyclerView.ViewHolder{
        public SearchResultLiveShowView liveShowView;
        public LiveShowViewholder(SearchResultLiveShowView itemView) {
            super(itemView);
            liveShowView=itemView;
        }
    }
    class NothingViewholder extends RecyclerView.ViewHolder{
        public SearchNothingView nothingView;
        public NothingViewholder(SearchNothingView itemView) {
            super(itemView);
            nothingView=itemView;
        }
    }

}
