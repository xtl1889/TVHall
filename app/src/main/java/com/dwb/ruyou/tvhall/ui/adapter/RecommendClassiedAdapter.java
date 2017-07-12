package com.dwb.ruyou.tvhall.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.model.RecommendClassiedBean;
import com.dwb.ruyou.tvhall.model.eventbusmodel.ClickRecommendItem;
import com.dwb.ruyou.tvhall.ui.ClassifiedDetailActivity;
import com.dwb.ruyou.tvhall.ui.base.BaseVerticalAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Slayer on 2017/7/11.
 */

public class RecommendClassiedAdapter extends BaseVerticalAdapter<RecommendClassiedBean> {
    public RecommendClassiedAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecommendClassiedViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recommend_classied_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final RecommendClassiedBean classiedBean=getItem(position);
        RecommendClassiedViewHolder classiedViewHolder= (RecommendClassiedViewHolder) holder;
        if ("more".equals(classiedBean.getTag())){
            classiedViewHolder.recommend_classied_tv.setText("更多常用");
        }
        if (!TextUtils.isEmpty(classiedBean.getName())){
            classiedViewHolder.recommend_classied_tv.setText(classiedBean.getName());
        }
        switch (position){
            case 0:
                classiedViewHolder.recommend_classied_iv.setImageResource(R.drawable.recommend_classied1);
                break;
            case 1:
                classiedViewHolder.recommend_classied_iv.setImageResource(R.drawable.recommend_classied2);
                break;
            case 2:
                classiedViewHolder.recommend_classied_iv.setImageResource(R.drawable.recommend_classied3);
                break;
            case 3:
                classiedViewHolder.recommend_classied_iv.setImageResource(R.drawable.recommend_classied4);
                break;
            case 4:
                classiedViewHolder.recommend_classied_iv.setImageResource(R.drawable.recommend_classied5);
                break;
        }
        classiedViewHolder.recommend_classied_item_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position==4){
                    EventBus.getDefault().post(new ClickRecommendItem("classified",2));
                }else {
                    Intent intent=new Intent(mContext,ClassifiedDetailActivity.class);
                    intent.putExtra("name",classiedBean.getName());
                    intent.putExtra("id",classiedBean.getId());
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    class RecommendClassiedViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout recommend_classied_item_layout;
        SimpleDraweeView recommend_classied_iv;
        TextView recommend_classied_tv;
        public RecommendClassiedViewHolder(View itemView) {
            super(itemView);
            recommend_classied_item_layout= (RelativeLayout) itemView.findViewById(R.id.recommend_classied_item_layout);
            recommend_classied_iv= (SimpleDraweeView) itemView.findViewById(R.id.recommend_classied_iv);
            recommend_classied_tv= (TextView) itemView.findViewById(R.id.recommend_classied_tv);
        }
    }
}
