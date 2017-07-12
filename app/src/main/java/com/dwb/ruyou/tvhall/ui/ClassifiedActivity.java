package com.dwb.ruyou.tvhall.ui;

import android.os.Bundle;
import android.support.v17.leanback.widget.VerticalGridView;
import android.support.v7.widget.GridLayoutManager;
import android.view.KeyEvent;
import android.widget.Toast;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.api.ApiConfig;
import com.dwb.ruyou.tvhall.api.TVhallApi;
import com.dwb.ruyou.tvhall.model.LiveShowTitle;
import com.dwb.ruyou.tvhall.model.eventbusmodel.TabToMainRequesfous;
import com.dwb.ruyou.tvhall.ui.adapter.ClassfiedAdapter;
import com.dwb.ruyou.tvhall.ui.base.BaseActivity;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvGridLayoutManager;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvRecyclerView;
import com.dwb.ruyou.tvhall.utils.RetrofitUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClassifiedActivity extends BaseActivity {

    private VerticalGridView verticalGridView;
    private TvRecyclerView tvRecyclerView;
    private ClassfiedAdapter classfiedAdapter;

    private TVhallApi tVhallApi;
    private Call<LiveShowTitle> liveShowTitleCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classified);
        tVhallApi= RetrofitUtils.getRestofitApi(ApiConfig.testUrl1,TVhallApi.class);
        liveShowTitleCall=tVhallApi.getLiveShowTitle();
        initView();
    }

    private void initView() {
        verticalGridView= (VerticalGridView) findViewById(R.id.verGV);
        tvRecyclerView= (TvRecyclerView) findViewById(R.id.classfied_rv);

        tvRecyclerView.setItemAnimator(null);
//        tvRecyclerView.setParentUpView(parentUpView);
        TvGridLayoutManager tvGridLayoutManager=new TvGridLayoutManager(this,4);
        tvGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        classfiedAdapter=new ClassfiedAdapter(this,tvRecyclerView);
        tvRecyclerView.setLayoutManager(tvGridLayoutManager);
//        recommend_rv.setSelectedItemOffset(180,180);
        tvRecyclerView.setAdapter(classfiedAdapter);
//        classfiedAdapter.addItems(creadData());
        getTitleData();
    }

    private void getTitleData() {
        liveShowTitleCall.enqueue(new Callback<LiveShowTitle>() {
            @Override
            public void onResponse(Call<LiveShowTitle> call, Response<LiveShowTitle> response) {
                if (response.body()!=null&&"SUCCESS".equals(response.body().getResult())){
                    classfiedAdapter.addItems(response.body().getList());

                }else {
                    Toast.makeText(ClassifiedActivity.this,"获取直播标题失败!",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LiveShowTitle> call, Throwable t) {
                Toast.makeText(ClassifiedActivity.this,"无法获取直播标题!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<String> creadData(){
        List<String> list=new ArrayList<>();
        for (int i = 0; i <21; i++) {
            list.add("Teemo--"+i);
        }
        return list;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_DOWN:
//                Log.e("keyDown", "gameActivity: --down---"+keyCode );
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
//                isSelect=true;
//                Log.e("keyDown", "gameActivity: --up---"+keyCode );
                EventBus.getDefault().post(new TabToMainRequesfous(true,"4"));
                break;
//                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
