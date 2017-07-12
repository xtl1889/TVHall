package com.dwb.ruyou.tvhall.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.ui.base.BaseVerticalAdapter;

/**
 * Created by Slayer on 2017/6/9.
 */

public class TestAdapter extends BaseVerticalAdapter<String> {


    public TestAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate( R.layout.text_item,parent,false);
        TestViewHolder testViewHolder=new TestViewHolder(view);
        return testViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final TestViewHolder testViewHolder= (TestViewHolder) holder;
        testViewHolder.textView.setText(getItem(position));

        testViewHolder.linearLayout.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b){
                    Log.e("foc", "onFocusChange: ------"+position );
                    testViewHolder.linearLayout.setBackgroundResource(R.drawable.item_selectbackground_shape);
//                    Toast.makeText(mContext,"-----"+position+"-----",Toast.LENGTH_SHORT).show();
                }else {
                    testViewHolder.linearLayout.setBackground(null);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    class TestViewHolder extends RecyclerView.ViewHolder{
        LinearLayout linearLayout;
        TextView textView;
        public TestViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.test_tv1);
            linearLayout= (LinearLayout) itemView.findViewById(R.id.test_Layout);
        }
    }
}
