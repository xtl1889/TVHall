package com.dwb.ruyou.tvhall.ui.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.model.TestModel;
import com.dwb.ruyou.tvhall.model.eventbusmodel.PersonFragmentToActivity;
import com.dwb.ruyou.tvhall.model.eventbusmodel.PersonLookedAdapterToFragment;
import com.dwb.ruyou.tvhall.ui.adapter.PersonCenter_Looked_Adapter;
import com.dwb.ruyou.tvhall.ui.base.BaseFragment;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvGridLayoutManager;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalCenter_Looked_Fragment extends BaseFragment implements View.OnClickListener{

    private TextView personal_manage_tv;
    private TvRecyclerView mTvRecyclerView;
    private PersonCenter_Looked_Adapter looked_adapter;

    public PersonalCenter_Looked_Fragment() {
        // Required empty public constructor
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_personal_center__looked_;
    }

    //监听点击向左按钮  标题获取焦点
    private TvRecyclerView.KeyLeftNoItem keyLeftNoItemListener=new TvRecyclerView.KeyLeftNoItem() {
        @Override
        public void leftNoItemListener() {
            EventBus.getDefault().post(new PersonFragmentToActivity(true,0));
        }
    };
    //点击 item监听
    private PersonCenter_Looked_Adapter.SetClickItemListener clickItemListener=new PersonCenter_Looked_Adapter.SetClickItemListener() {
        @Override
        public void clickItemListener(int position, View view) {
            if (testDataList!=null&&testDataList.size()>position){
                if (isShowDelImg){
                    Log.e("person", "clickItemListener: ---del--"+position );
                    looked_adapter.delectItem(position);
                    personal_manage_tv.requestFocus();
                }else {
                    Log.e("person", "clickItemListener: -----"+position );
                }
            }
        }
    };

    @Override
    public void initView() {
        super.initView();
        personal_manage_tv= (TextView) view.findViewById(R.id.personal_manage_tv);
        personal_manage_tv.setOnClickListener(this);
        mTvRecyclerView= (TvRecyclerView) view.findViewById(R.id.personalCenter_looked_rv);
        TvGridLayoutManager tvGridLayoutManager=new TvGridLayoutManager(mContext,3);
        tvGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        looked_adapter=new PersonCenter_Looked_Adapter(mContext,mTvRecyclerView);

//        mTvRecyclerView.setFocusable(false);
        mTvRecyclerView.setItemAnimator(null);
        mTvRecyclerView.setLayoutManager(tvGridLayoutManager);
//        mTvRecyclerView.setSelectedItemOffset(180,180);
        mTvRecyclerView.setAdapter(looked_adapter);

        looked_adapter.addItems(creadData());
        mTvRecyclerView.setKeyLeftNoItemListener(keyLeftNoItemListener,0);
        looked_adapter.setClickItemListener(clickItemListener);
    }


    /**
     * 管理按钮获取焦点
     * */
    @Subscribe(threadMode = ThreadMode.POSTING) // ThreadMode is optional here
    public void onMessage(PersonLookedAdapterToFragment adapterToFragment) {
        if (adapterToFragment.isReques()){
            personal_manage_tv.requestFocus();
        }
    }
    private List<TestModel> testDataList;
    private boolean isShowDelImg;
    private List<TestModel> creadData(){
        testDataList=new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            TestModel testModel=new TestModel();
            testModel.setResult("主播--"+i);
            testModel.setShowDelImg(isShowDelImg);
            testDataList.add(testModel);
        }
        return testDataList;
    }

    private void changeList(){
        for (int i = 0; i < testDataList.size(); i++) {
            testDataList.get(i).setShowDelImg(isShowDelImg);
        }
    }
//    private void deleteItem(int i){
//
//    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.personal_manage_tv:
                isShowDelImg=!isShowDelImg;
                changeList();
                looked_adapter.notifyDataSetChanged();
                break;
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
