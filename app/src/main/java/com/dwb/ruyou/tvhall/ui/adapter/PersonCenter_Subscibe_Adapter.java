package com.dwb.ruyou.tvhall.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.model.TestModel;
import com.dwb.ruyou.tvhall.ui.base.BaseVerticalAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Slayer on 2017/6/26.
 */

public class PersonCenter_Subscibe_Adapter extends BaseVerticalAdapter<TestModel>{

    public PersonCenter_Subscibe_Adapter(Context mContext) {
        super(mContext);
    }

//item的点击事件
    private SetClickItemListener clickItemListener;
    public interface SetClickItemListener{
        void clickItemListener(int position, View view);
    }
    public void setClickItemListener(SetClickItemListener clickItemListener){
        this.clickItemListener=clickItemListener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LookedViewHolder(LayoutInflater.from(mContext).inflate(R.layout.live_show_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final LookedViewHolder lookedViewHolder= (LookedViewHolder) holder;
        lookedViewHolder.anchor_name_tv.setText(mItemList.get(position).getResult());
        if (mItemList.get(position).isShowDelImg()){
            lookedViewHolder.looked_item_delete_layout.setVisibility(View.VISIBLE);
        }else {
            lookedViewHolder.looked_item_delete_layout.setVisibility(View.INVISIBLE);
        }

        lookedViewHolder.live_show_item_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickItemListener!=null){
                    clickItemListener.clickItemListener(position,view);
                }
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
