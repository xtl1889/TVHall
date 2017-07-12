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
import com.dwb.ruyou.tvhall.model.eventbusmodel.MainToTabRequesfous;
import com.dwb.ruyou.tvhall.ui.base.BaseVerticalAdapter;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvRecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Slayer on 2017/6/26.
 */

public class LiveShow_all_Adapter extends BaseVerticalAdapter<LiveShowItemBean>{
    private TvRecyclerView tvRecyclerView;
    public LiveShow_all_Adapter(Context mContext) {
        super(mContext);
    }

    public LiveShow_all_Adapter(Context mContext, TvRecyclerView tvRecyclerView) {
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

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LookedViewHolder(LayoutInflater.from(mContext).inflate(R.layout.live_show_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final LookedViewHolder lookedViewHolder= (LookedViewHolder) holder;
        if (mItemList.get(position).isShowDelectImg()){
            lookedViewHolder.looked_item_delete_layout.setVisibility(View.VISIBLE);
        }else {
            lookedViewHolder.looked_item_delete_layout.setVisibility(View.GONE);
        }
        lookedViewHolder.anchor_name_tv.setText(mItemList.get(position).getUserName());
        lookedViewHolder.anchor_room_tv.setText(mItemList.get(position).getLivingShowRoomName());
        lookedViewHolder.live_show_img.setImageURI(mItemList.get(position).getImg());
        lookedViewHolder.anchor_head_img.setImageURI(mItemList.get(position).getUserAvatar());
        lookedViewHolder.look_anchor_num_tv.setText(" "+mItemList.get(position).getAudienceNumber());
        lookedViewHolder.live_show_item_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickItemListener!=null){
                    clickItemListener.clickItemListener(position,view);
                }
            }
        });

        lookedViewHolder.live_show_item_layout.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (i) {
                        case KeyEvent.KEYCODE_DPAD_UP:
                            if (tvRecyclerView.isTopEdge(position)){
//                                if (parentView!=null){
//                                    parentView.requestFocus();
//                                }
                                EventBus.getDefault().post(new MainToTabRequesfous(true,String.valueOf("1")));
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
    class LookedViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout live_show_item_layout;
        RelativeLayout looked_item_delete_layout;
        SimpleDraweeView live_show_img,anchor_head_img;
        TextView anchor_name_tv,anchor_room_tv,look_anchor_num_tv;

        public LookedViewHolder(View itemView) {
            super(itemView);
            live_show_item_layout= (RelativeLayout) itemView.findViewById(R.id.live_show_item_layout);
            looked_item_delete_layout= (RelativeLayout) itemView.findViewById(R.id.looked_item_delete_layout);
            live_show_img= (SimpleDraweeView) itemView.findViewById(R.id.live_show_img);
            anchor_head_img= (SimpleDraweeView) itemView.findViewById(R.id.anchor_head_img);
            anchor_name_tv= (TextView) itemView.findViewById(R.id.anchor_name_tv);
            anchor_room_tv= (TextView) itemView.findViewById(R.id.anchor_room_tv);
            look_anchor_num_tv= (TextView) itemView.findViewById(R.id.look_anchor_num_tv);
        }
    }
}
