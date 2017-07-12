package com.dwb.ruyou.tvhall.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.ui.base.BaseVerticalAdapter;

/**
 * Created by Slayer on 2017/7/5.
 */

public class GameTitleAdapter extends BaseVerticalAdapter<String> {


    public GameTitleAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GameTitleViewHoder(LayoutInflater.from(mContext).inflate(R.layout.game_title_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GameTitleViewHoder titleViewHoder= (GameTitleViewHoder) holder;
        titleViewHoder.game_title_tv.setText(mItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class GameTitleViewHoder extends RecyclerView.ViewHolder{
        TextView game_title_tv;
        ImageView game_title_img;
        public GameTitleViewHoder(View itemView) {
            super(itemView);
            game_title_tv= (TextView) itemView.findViewById(R.id.game_title_tv);
            game_title_img= (ImageView) itemView.findViewById(R.id.game_title_img);
        }
    }
}
