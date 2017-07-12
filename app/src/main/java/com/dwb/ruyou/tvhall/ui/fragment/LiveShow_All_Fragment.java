package com.dwb.ruyou.tvhall.ui.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.KeyEvent;
import android.widget.Toast;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.api.ApiConfig;
import com.dwb.ruyou.tvhall.api.TVhallApi;
import com.dwb.ruyou.tvhall.model.LiveShowList;
import com.dwb.ruyou.tvhall.model.TestModel;
import com.dwb.ruyou.tvhall.ui.adapter.LiveShow_all_Adapter;
import com.dwb.ruyou.tvhall.ui.base.BaseFragment;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvGridLayoutManager;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvRecyclerView;
import com.dwb.ruyou.tvhall.utils.LogUtils;
import com.dwb.ruyou.tvhall.utils.RetrofitUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * 直播页面的fragment
 */
public class LiveShow_All_Fragment extends BaseFragment {

    private TvRecyclerView liveshow_all_recycler;
    private LiveShow_all_Adapter all_adapter;

    private TVhallApi tVhallApi;
    private Call<LiveShowList> liveShowListCall;
    private int liveShowId;//游戏id

    public LiveShow_All_Fragment() {
        // Required empty public constructor
    }

    public LiveShow_All_Fragment(int liveShowId) {
        this.liveShowId = liveShowId;
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_live_show__all_;
    }

    @Override
    public void initView() {
        super.initView();
        tVhallApi= RetrofitUtils.getRestofitApi(ApiConfig.testUrl1,TVhallApi.class);
        liveShowListCall=tVhallApi.getLiveShowList(liveShowId);
        LogUtils.LOGD("liveShow----fragment-----liveShowid----"+liveShowId);
        liveshow_all_recycler= (TvRecyclerView) view.findViewById(R.id.liveshow_all_recycler);
        TvGridLayoutManager tvGridLayoutManager=new TvGridLayoutManager(mContext,4);
        tvGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        all_adapter=new LiveShow_all_Adapter(mContext,liveshow_all_recycler);

//        mTvRecyclerView.setFocusable(false);
        liveshow_all_recycler.setItemAnimator(null);
        liveshow_all_recycler.setLayoutManager(tvGridLayoutManager);
//        mTvRecyclerView.setSelectedItemOffset(180,180);
        liveshow_all_recycler.setAdapter(all_adapter);
        getLiveShowData();
    }

    private void getLiveShowData() {
        liveShowListCall.enqueue(new Callback<LiveShowList>() {
            @Override
            public void onResponse(Call<LiveShowList> call, Response<LiveShowList> response) {
                if (response.body()!=null&&"SUCCESS".equals(response.body().getResult())){
                    if (all_adapter!=null){
                        all_adapter.addItems(response.body().getList());
                    }
                }else {
                    LogUtils.LOGD("liveShowFragment------url-----"+call.request().url());
                    Toast.makeText(mContext,"获取直播列表失败!",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LiveShowList> call, Throwable t) {
                Toast.makeText(mContext,"无法获取直播列表!",Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_UP://按向上按钮时 标题栏获取焦点
//                mParentActivity.requestTabFocus();
                return true;
        }
        return super.onKeyDown(keyCode, event);
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
