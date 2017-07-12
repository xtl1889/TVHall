package com.dwb.ruyou.tvhall.ui.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.model.eventbusmodel.PersonFragmentToActivity;
import com.dwb.ruyou.tvhall.ui.adapter.PersonCenter_mygame_adapter;
import com.dwb.ruyou.tvhall.ui.base.BaseFragment;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvGridLayoutManager;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * 个人中心  我的游戏界面
 */
public class PersonCenter_Mygame_Fragment extends BaseFragment {

    private TvRecyclerView tvRecyclerView;
    private PersonCenter_mygame_adapter mygame_adapter;
    public PersonCenter_Mygame_Fragment() {
        // Required empty public constructor
    }

    //监听点击向左按钮  标题获取焦点
    private TvRecyclerView.KeyLeftNoItem keyLeftNoItemListener=new TvRecyclerView.KeyLeftNoItem() {
        @Override
        public void leftNoItemListener() {
            EventBus.getDefault().post(new PersonFragmentToActivity(true,2));
        }
    };
    @Override
    public int getViewId() {
        return R.layout.fragment_person_center__mygame_;
    }

    @Override
    public void initView() {
        super.initView();
        tvRecyclerView= (TvRecyclerView) view.findViewById(R.id.personalCenter_mygame_rv);
        mygame_adapter=new PersonCenter_mygame_adapter(mContext);

        tvRecyclerView.setFocusable(false);
        tvRecyclerView.setItemAnimator(null);
//        tvRecyclerView.setParentUpView(parentUpView);
        TvGridLayoutManager tvGridLayoutManager=new TvGridLayoutManager(mContext,4);
        tvGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);

        tvRecyclerView.setLayoutManager(tvGridLayoutManager);
        tvRecyclerView.setSelectedItemOffset(180,180);
        tvRecyclerView.setAdapter(mygame_adapter);
        mygame_adapter.addItems(creadData());

        tvRecyclerView.setKeyLeftNoItemListener(keyLeftNoItemListener,0);
    }

    private List<String> creadData(){
        List<String> list=new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add("游戏--"+i);
        }
        return list;
    }

}
