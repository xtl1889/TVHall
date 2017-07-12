package com.dwb.ruyou.tvhall.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.model.LiveShowTitle;
import com.dwb.ruyou.tvhall.model.eventbusmodel.TabToMainRequesfous;
import com.dwb.ruyou.tvhall.ui.ClassifiedDetailActivity;
import com.dwb.ruyou.tvhall.ui.base.BaseVerticalAdapter;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvRecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Slayer on 2017/6/28.
 */

public class ClassfiedAdapter extends BaseVerticalAdapter<LiveShowTitle.ListBean> {
    private TvRecyclerView tvRecyclerView;

    public ClassfiedAdapter(Context mContext) {
        super(mContext);
    }

    public ClassfiedAdapter(Context mContext, TvRecyclerView tvRecyclerView) {
        super(mContext);
        this.tvRecyclerView = tvRecyclerView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ClassiedViewHolder(LayoutInflater.from(mContext).inflate(R.layout.classied_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
//        TestModel testModel=getItem(position);
        ClassiedViewHolder classiedViewHolder= (ClassiedViewHolder) holder;

        classiedViewHolder.classfied_tv.setText(mItemList.get(position).getName());
        classiedViewHolder.classfied_img.setImageURI(mItemList.get(position).getImg());
        classiedViewHolder.classfied_Layout.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (i) {
                        case KeyEvent.KEYCODE_DPAD_UP:
                            if (tvRecyclerView.isTopEdge(position)){
                                EventBus.getDefault().post(new TabToMainRequesfous(true,"4"));
                                return true;
                            }
                            break;
                    }
                }
                return false;
            }
        });

        classiedViewHolder.classfied_Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext,ClassifiedDetailActivity.class);
                intent.putExtra("name",mItemList.get(position).getName());
                intent.putExtra("id",mItemList.get(position).getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    class ClassiedViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout classfied_Layout;
        SimpleDraweeView classfied_img;
        TextView classfied_tv;
        public ClassiedViewHolder(View itemView) {
            super(itemView);
            classfied_Layout= (RelativeLayout) itemView.findViewById(R.id.classfied_Layout);
            classfied_img= (SimpleDraweeView) itemView.findViewById(R.id.classfied_img);
            classfied_tv= (TextView) itemView.findViewById(R.id.classfied_tv);
            TextPaint tp = classfied_tv .getPaint();
            tp.setFakeBoldText(true);
        }
    }
}
