package com.dwb.ruyou.tvhall.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.ui.base.BaseVerticalAdapter;
import com.dwb.ruyou.tvhall.utils.DensityUtils;

/**
 * Created by Slayer on 2017/6/19.
 */

public class KeyBoartAdapter extends BaseVerticalAdapter<String> {


    private int itemHeight;
    private ClickKeyBoart clickKeyBoart;
    public KeyBoartAdapter(Context mContext) {
        super(mContext);
    }

    public KeyBoartAdapter(Context mContext, ClickKeyBoart clickKeyBoart) {
        super(mContext);
        this.clickKeyBoart = clickKeyBoart;
    }

    public interface ClickKeyBoart{
        void getKeyBoartString(String s);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.item_keyboart,parent,false);
        if (itemHeight!=0){
            view.getLayoutParams().height=itemHeight- DensityUtils.dp2px(mContext,8);
        }
        return new KeyBoartHoldr(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final KeyBoartHoldr keyBoartHoldr= (KeyBoartHoldr) holder;
        keyBoartHoldr.keyTv.setText(mItemList.get(position));
//        Log.e("keyboart", "onBindViewHolder: ------"+position );
        keyBoartHoldr.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickKeyBoart.getKeyBoartString(keyBoartHoldr.keyTv.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
    class KeyBoartHoldr extends RecyclerView.ViewHolder{
        TextView keyTv;
        LinearLayout itemLayout;
        public KeyBoartHoldr(View itemView) {
            super(itemView);
            keyTv= (TextView) itemView.findViewById(R.id.keyboart_item_tv);
            itemLayout= (LinearLayout) itemView.findViewById(R.id.keyboart_item_layout);
        }
    }

    public void setItemHeight(int i){
        if (i!=0){
            itemHeight=i;
        }
    }
}
