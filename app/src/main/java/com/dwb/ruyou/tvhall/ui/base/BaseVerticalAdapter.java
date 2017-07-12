package com.dwb.ruyou.tvhall.ui.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slayer on 2017/6/9.
 */

public abstract class BaseVerticalAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    protected List<T> mItemList;
    protected Context mContext;

    public BaseVerticalAdapter( Context mContext) {
        this.mContext = mContext;
        mItemList = new ArrayList<>();
    }

    public void addItem(T item){
        if (item==null)return;
        mItemList.add(mItemList.size(),item);
        notifyItemInserted(mItemList.size());
    }
    public void addItems(List<T> items){
        if (items==null)return;
        mItemList.addAll(items);
        notifyDataSetChanged();
    }

    public void updateItem(T item,int position){
        if (item==null)return;
        mItemList.add(position,item);
        notifyDataSetChanged();
    }

    public void updateItems(List<T> items){
        if (items==null)return;
        mItemList.clear();
        mItemList.addAll(items);
        notifyDataSetChanged();
    }

    public void delectItem(int position){
        mItemList.remove(position);
        notifyDataSetChanged();
    }
    public void clearItem(){
        mItemList.clear();
        notifyDataSetChanged();
    }
    public T getItem(int position){
        return mItemList.get(position);
    }
}
