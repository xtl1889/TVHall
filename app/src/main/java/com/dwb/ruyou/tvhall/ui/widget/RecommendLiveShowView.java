package com.dwb.ruyou.tvhall.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.model.LiveShowItemBean;
import com.dwb.ruyou.tvhall.model.eventbusmodel.TabToMainRequesfous;
import com.dwb.ruyou.tvhall.ui.PersonalCenterActivity;
import com.dwb.ruyou.tvhall.ui.adapter.LiveShowAdapter;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvGridLayoutManager;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by Slayer on 2017/7/7.
 */

public class RecommendLiveShowView extends RelativeLayout {

    private Context mContext;
    private TvRecyclerView mRecyclerView;
    private LiveShowAdapter adapter;
    public RecommendLiveShowView(Context context) {
        super(context);
        this.mContext=context;
        initView();
    }

    private void initView() {
        View view= LayoutInflater.from(mContext).inflate(R.layout.recyclerview_layout,this);
        mRecyclerView= (TvRecyclerView) view.findViewById(R.id.recyclerView_layout);
        mRecyclerView.setKeyDownNoItemListener(null,1);
//        mRecyclerView.setKeyUpNoItemListener(null,1);
        adapter=new LiveShowAdapter(mContext,mRecyclerView);
        adapter.setKeyUpnoItemListener(keyUpnoItemListener);
        adapter.setClickItemListener(clickItemListener);
        TvGridLayoutManager tvGridLayoutManager=new TvGridLayoutManager(mContext,5);
        tvGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(tvGridLayoutManager);
        mRecyclerView.setItemAnimator(null);
        mRecyclerView.setAdapter(adapter);
    }
    public void addItem(List<LiveShowItemBean> listItem){
        if (adapter!=null&&listItem!=null){
            adapter.updateItems(listItem);
        }
    }

    LiveShowAdapter.KeyUpnoItemListener keyUpnoItemListener=new LiveShowAdapter.KeyUpnoItemListener() {
        @Override
        public void upNoitemListener(int position, View view) {
            EventBus.getDefault().post(new TabToMainRequesfous(true,"1"));
        }
    };
    LiveShowAdapter.ClickItemListener clickItemListener=new LiveShowAdapter.ClickItemListener() {
        @Override
        public void clickItemListener(int position, View view) {
            if (position==4){
                Intent intent=new Intent(mContext,PersonalCenterActivity.class);
                intent.putExtra("showFragmentTag",1);
                mContext.startActivity(intent);
            }else if (position==9){
                Intent intent2=new Intent(mContext,PersonalCenterActivity.class);
                intent2.putExtra("showFragmentTag",2);
                mContext.startActivity(intent2);
            }
        }
    };

}
