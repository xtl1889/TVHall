package com.dwb.ruyou.tvhall.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.ui.base.BaseVerticalAdapter;
import com.dwb.ruyou.tvhall.ui.widget.GameStarView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slayer on 2017/6/9.
 */

public class PersonCenter_mygame_adapter extends BaseVerticalAdapter<String> {


    public PersonCenter_mygame_adapter(Context mContext) {
        super(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate( R.layout.game_item,parent,false);
        GameAllViewholder gameAllViewholder=new GameAllViewholder(view);
        return gameAllViewholder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final GameAllViewholder viewholder= (GameAllViewholder) holder;

        viewholder.linearLayout.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b){
                    Log.e("foc", "onFocusChange: ------"+position );
                    viewholder.linearLayout.setBackgroundResource(R.drawable.item_selectbackground_shape);
                }else {
                    viewholder.linearLayout.setBackground(null);
                }
            }
        });

        viewholder.gameStarView.setGameName(mItemList.get(position));
        viewholder.gameStarView.setGameStart(creadGameStart());

        viewholder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mContext.startActivity(new Intent(mContext, GameDetailActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    class GameAllViewholder extends RecyclerView.ViewHolder{
        LinearLayout linearLayout;
        SimpleDraweeView game_all_img;
        GameStarView gameStarView;
        public GameAllViewholder(View itemView) {
            super(itemView);
            linearLayout= (LinearLayout) itemView.findViewById(R.id.game_item_Layout);
            game_all_img= (SimpleDraweeView) itemView.findViewById(R.id.game_all_img);
            gameStarView= (GameStarView) itemView.findViewById(R.id.game_star_view);
        }
    }

    private List<Integer> creadGameStart(){
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        return list;
    }
}
