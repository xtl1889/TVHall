package com.dwb.ruyou.tvhall.ui.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.model.GameItemBean;
import com.dwb.ruyou.tvhall.model.eventbusmodel.MainToTabRequesfous;
import com.dwb.ruyou.tvhall.ui.base.BaseVerticalAdapter;
import com.dwb.ruyou.tvhall.ui.widget.GameStarView;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvRecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slayer on 2017/6/9.
 */

public class Game_all_adapter extends BaseVerticalAdapter<GameItemBean> {

    private TvRecyclerView tvRecyclerView;
    private GridLayoutManager gridLayoutManager;
    private View parentView;


    public Game_all_adapter(Context mContext) {
        super(mContext);
    }

    public Game_all_adapter(Context mContext, TvRecyclerView tvRecyclerView) {
        super(mContext);
        this.tvRecyclerView = tvRecyclerView;
    }

    public Game_all_adapter(Context mContext, TvRecyclerView tvRecyclerView, GridLayoutManager gridLayoutManager, View parentView) {
        super(mContext);
        this.tvRecyclerView = tvRecyclerView;
        this.gridLayoutManager = gridLayoutManager;
        this.parentView=parentView;
    }

    private ClickItmeListener clickItmeListener;
    public interface ClickItmeListener{
        void clickItem(View view,int pos,String appKey,String gameType);
    }
    public void setClickItemListener(ClickItmeListener clickItemListener){
        this.clickItmeListener=clickItemListener;
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
        final GameItemBean tvGameListBean=mItemList.get(position);

        viewholder.gameStarView.setGameName(tvGameListBean.getGameName());
//        viewholder.game_all_img.setImageURI(ApiConfig.iconUrl+tvGameListBean.getIcon());
        viewholder.gameStarView.setGameStart(creadGameStart(tvGameListBean.getStar()));

        viewholder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickItmeListener!=null){
                    clickItmeListener.clickItem(view,position,tvGameListBean.getAppKey(),tvGameListBean.getGameType());
                }
            }
        });

        viewholder.linearLayout.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (i) {
                        case KeyEvent.KEYCODE_DPAD_UP:
                            if (tvRecyclerView!=null&&tvRecyclerView.isTopEdge(position)){
                                EventBus.getDefault().post(new MainToTabRequesfous(true,String.valueOf("2")));
                                return true;
                            }
                            break;
                    }
                }
                return false;
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

    private List<Integer> creadGameStart(int n){
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (i<n){
                list.add(1);
            }else {
                list.add(0);
            }
        }
        return list;
    }
}
