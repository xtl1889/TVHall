package com.dwb.ruyou.tvhall.ui.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.model.TestModel;
import com.dwb.ruyou.tvhall.model.eventbusmodel.PersonFragmentToActivity;
import com.dwb.ruyou.tvhall.ui.adapter.PersonCenter_Subscibe_Adapter;
import com.dwb.ruyou.tvhall.ui.base.BaseFragment;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvGridLayoutManager;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * 个人中心订阅界面
 */
public class PersonCener_Subscibe_Fragment extends BaseFragment {


    private TvRecyclerView mTvRecyclerView;
    private PersonCenter_Subscibe_Adapter subscibe_adapter;
    public PersonCener_Subscibe_Fragment() {
        // Required empty public constructor
    }

    //监听点击向左按钮  标题获取焦点
    private TvRecyclerView.KeyLeftNoItem keyLeftNoItemListener=new TvRecyclerView.KeyLeftNoItem() {
        @Override
        public void leftNoItemListener() {
            EventBus.getDefault().post(new PersonFragmentToActivity(true,1));
        }
    };
    //点击 item监听
    private PersonCenter_Subscibe_Adapter.SetClickItemListener clickItemListener=new PersonCenter_Subscibe_Adapter.SetClickItemListener() {
        @Override
        public void clickItemListener(int position, View view) {

        }
    };

    @Override
    public int getViewId() {
        return R.layout.fragment_person_cener__subscibe_;
    }

    @Override
    public void initView() {
        super.initView();
        mTvRecyclerView= (TvRecyclerView) view.findViewById(R.id.personalCenter_subscibe_rv);

        TvGridLayoutManager tvGridLayoutManager=new TvGridLayoutManager(mContext,4);
        tvGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        subscibe_adapter=new PersonCenter_Subscibe_Adapter(mContext);

//        mTvRecyclerView.setFocusable(false);
        mTvRecyclerView.setItemAnimator(null);
        mTvRecyclerView.setLayoutManager(tvGridLayoutManager);
//        mTvRecyclerView.setSelectedItemOffset(180,180);
        mTvRecyclerView.setAdapter(subscibe_adapter);
        subscibe_adapter.addItems(creadData());

        mTvRecyclerView.setKeyLeftNoItemListener(keyLeftNoItemListener,0);
        subscibe_adapter.setClickItemListener(clickItemListener);
    }


    private List<TestModel> testDataList;
    private List<TestModel> creadData(){
        testDataList=new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            TestModel testModel=new TestModel();
            testModel.setResult("主播--"+i);
            testDataList.add(testModel);
        }
        return testDataList;
    }
}
