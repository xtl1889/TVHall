package com.dwb.ruyou.tvhall.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.ui.base.BaseVerticalAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Slayer on 2017/6/15.
 */

public class GameStarAdapter extends BaseVerticalAdapter<Integer> {
    public GameStarAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StarImgHolder(LayoutInflater.from(mContext).inflate(R.layout.item_start,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        StarImgHolder starImgHolder= (StarImgHolder) holder;
        int i=mItemList.get(position);
        if (i==1){
            starImgHolder.starImg.setImageResource(R.drawable.game_star3);
        }else {
            starImgHolder.starImg.setImageResource(R.drawable.game_star1);
        }
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    class StarImgHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView starImg;
        public StarImgHolder(View itemView) {
            super(itemView);
            starImg= (SimpleDraweeView) itemView.findViewById(R.id.star_img);
        }
    }
}
