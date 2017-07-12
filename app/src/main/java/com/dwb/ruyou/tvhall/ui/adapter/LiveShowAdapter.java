package com.dwb.ruyou.tvhall.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.model.LiveShowItemBean;
import com.dwb.ruyou.tvhall.ui.base.BaseVerticalAdapter;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvRecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Slayer on 2017/6/26.
 */

public class LiveShowAdapter extends BaseVerticalAdapter<LiveShowItemBean>{
    private TvRecyclerView tvRecyclerView;
    public LiveShowAdapter(Context mContext) {
        super(mContext);
    }

    public LiveShowAdapter(Context mContext, TvRecyclerView tvRecyclerView) {
        super(mContext);
        this.tvRecyclerView = tvRecyclerView;
    }

//item的点击事件
    private ClickItemListener clickItemListener;
    public interface ClickItemListener{
        void clickItemListener(int position, View view);
    }
    public void setClickItemListener(ClickItemListener clickItemListener){
        this.clickItemListener=clickItemListener;
    }

    //点击向上按钮没有 选项的监听
    private KeyUpnoItemListener keyUpnoItemListener;
    public interface KeyUpnoItemListener{
        void upNoitemListener(int position, View view);
    }
    public void setKeyUpnoItemListener(KeyUpnoItemListener keyUpnoItemListener){
        this.keyUpnoItemListener=keyUpnoItemListener;
    }
    @Override
    public int getItemViewType(int position) {
        String viewTag=getItem(position).getViewTag();
        if ("myView".equals(viewTag)){//主要跟推荐页相关
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder=null;
        switch (viewType){
            case 0:
                viewHolder=new LiveShowViewHolder(LayoutInflater.from(mContext).inflate(R.layout.live_show_item,parent,false));
                break;
            case 1:
            viewHolder=new SubscibeGameViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recommend_subscibe_game_item,parent,false));
            break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        LiveShowItemBean liveShowItemBean=getItem(position);
        switch (getItemViewType(position)){
            case 0:
                final LiveShowViewHolder liveShowViewHolder= (LiveShowViewHolder) holder;
                if (mItemList.get(position).isShowDelectImg()){
                    liveShowViewHolder.looked_item_delete_layout.setVisibility(View.VISIBLE);
                }else {
                    liveShowViewHolder.looked_item_delete_layout.setVisibility(View.GONE);
                }
                liveShowViewHolder.anchor_name_tv.setText(mItemList.get(position).getUserName());
                liveShowViewHolder.anchor_room_tv.setText(mItemList.get(position).getLivingShowRoomName());
                liveShowViewHolder.live_show_img.setImageURI(mItemList.get(position).getImg());
                liveShowViewHolder.anchor_head_img.setImageURI(mItemList.get(position).getUserAvatar());
                liveShowViewHolder.look_anchor_num_tv.setText(" "+mItemList.get(position).getAudienceNumber());
                liveShowViewHolder.live_show_item_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (clickItemListener!=null){
                            clickItemListener.clickItemListener(position,view);
                        }
                    }
                });
                liveShowViewHolder.live_show_item_layout.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View view, int i, KeyEvent keyEvent) {
                        if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                            switch (i) {
                                case KeyEvent.KEYCODE_DPAD_UP:
                                    if (tvRecyclerView!=null&&tvRecyclerView.isTopEdge(position)){
                                        if (keyUpnoItemListener!=null){
                                            keyUpnoItemListener.upNoitemListener(position,view);
                                            return true;
                                        }
                                    }
                                    break;
                            }
                        }
                        return false;
                    }
                });
                break;
            case 1:
                SubscibeGameViewHolder subscibeGameViewHolder= (SubscibeGameViewHolder) holder;
                if ("subscibe".equals(liveShowItemBean.getTag())){
                   subscibeGameViewHolder.recommend_subscibe_game_img.setImageResource(R.drawable.recommend_subscibe);
                    subscibeGameViewHolder.recommend_subscibe_game_tv.setText("我的订阅");
                }else if ("game".equals(liveShowItemBean.getTag())){
                    subscibeGameViewHolder.recommend_subscibe_game_img.setImageResource(R.drawable.recommend_game);
                    subscibeGameViewHolder.recommend_subscibe_game_tv.setText("我的游戏");
                }
                subscibeGameViewHolder.recommend_subscibe_game_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        clickItemListener.clickItemListener(position,view);
                    }
                });
                break;
        }

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
    class LiveShowViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout live_show_item_layout;
        RelativeLayout looked_item_delete_layout,look_anchor_num_layout;
        SimpleDraweeView live_show_img,anchor_head_img;
        TextView anchor_name_tv,anchor_room_tv,look_anchor_num_tv;
        public LiveShowViewHolder(View itemView) {
            super(itemView);
            live_show_item_layout= (RelativeLayout) itemView.findViewById(R.id.live_show_item_layout);
            look_anchor_num_layout= (RelativeLayout) itemView.findViewById(R.id.look_anchor_num_layout);
            looked_item_delete_layout= (RelativeLayout) itemView.findViewById(R.id.looked_item_delete_layout);
            live_show_img= (SimpleDraweeView) itemView.findViewById(R.id.live_show_img);
            anchor_head_img= (SimpleDraweeView) itemView.findViewById(R.id.anchor_head_img);
            anchor_name_tv= (TextView) itemView.findViewById(R.id.anchor_name_tv);
            anchor_room_tv= (TextView) itemView.findViewById(R.id.anchor_room_tv);
            look_anchor_num_tv= (TextView) itemView.findViewById(R.id.look_anchor_num_tv);
            anchor_name_tv.setMaxEms(3);
            anchor_room_tv.setMaxEms(5);
        }
    }

    class SubscibeGameViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout recommend_subscibe_game_layout;
        SimpleDraweeView recommend_subscibe_game_bg_img;
        SimpleDraweeView recommend_subscibe_game_img;
        TextView recommend_subscibe_game_tv;

        public SubscibeGameViewHolder(View itemView) {
            super(itemView);
            recommend_subscibe_game_layout= (RelativeLayout) itemView.findViewById(R.id.recommend_subscibe_game_layout);
            recommend_subscibe_game_bg_img= (SimpleDraweeView) itemView.findViewById(R.id.recommend_subscibe_game_bg_img);
            recommend_subscibe_game_img= (SimpleDraweeView) itemView.findViewById(R.id.recommend_subscibe_game_img);
            recommend_subscibe_game_tv= (TextView) itemView.findViewById(R.id.recommend_subscibe_game_tv);
        }
    }
}
