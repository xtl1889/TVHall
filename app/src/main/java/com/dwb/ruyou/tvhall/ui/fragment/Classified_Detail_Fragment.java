package com.dwb.ruyou.tvhall.ui.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.model.TestModel;
import com.dwb.ruyou.tvhall.ui.adapter.Classified_Detail_Adapter;
import com.dwb.ruyou.tvhall.ui.base.BaseFragment;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvGridLayoutManager;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Classified_Detail_Fragment extends BaseFragment {

    private TvRecyclerView tvRecyclerView;
    private Classified_Detail_Adapter detail_adapter;
    public Classified_Detail_Fragment() {
        // Required empty public constructor
    }
    @Override
    public int getViewId() {
        return R.layout.fragment_classified__detail_;
    }

    @Override
    public void initView() {
        super.initView();
        tvRecyclerView= (TvRecyclerView) view.findViewById(R.id.calssified_detail_recycler);

        TvGridLayoutManager tvGridLayoutManager=new TvGridLayoutManager(mContext,4);
        tvGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        detail_adapter=new Classified_Detail_Adapter(mContext,tvRecyclerView);

//        mTvRecyclerView.setFocusable(false);
        tvRecyclerView.setItemAnimator(null);
        tvRecyclerView.setLayoutManager(tvGridLayoutManager);
//        mTvRecyclerView.setSelectedItemOffset(180,180);
        tvRecyclerView.setAdapter(detail_adapter);

        detail_adapter.addItems(creadData());
    }

    private List<TestModel> testDataList;
    private boolean isShowDelImg;
    private List<TestModel> creadData(){
        testDataList=new ArrayList<>();
        for (int i = 0; i < 17; i++) {
            TestModel testModel=new TestModel();
            testModel.setResult("主播--"+i);
            testModel.setShowDelImg(isShowDelImg);
            testDataList.add(testModel);
        }
        return testDataList;
    }
}
