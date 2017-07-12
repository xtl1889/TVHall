package com.dwb.ruyou.tvhall.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.ui.widget.CustomRecyclerView;

import java.util.List;

/**
 * Created by Slayer on 2017/6/13.
 */

public class CustomerAdpter extends CustomRecyclerView.CustomAdapter<String> {
    private List<String> mlist;

    public CustomerAdpter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected RecyclerView.ViewHolder onSetViewHolder(View view) {
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @NonNull
    @Override
    protected int onSetItemLayout() {
        return R.layout.text_item;
    }

    @Override
    protected void onSetItemData(RecyclerView.ViewHolder viewHolder, int position) {
        MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
        myViewHolder.textView.setText(mData.get(position));
    }

    @Override
    protected void onItemFocus(View itemView, int position) {
        itemView.setBackgroundColor(Color.GRAY);
    }

    @Override
    protected void onItemGetNormal(View itemView, int position) {
        itemView.setBackground(null);
    }

    @Override
    protected int getCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.test_tv1);
        }
    }
}
