package com.dwb.ruyou.tvhall.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.api.ApiConfig;
import com.dwb.ruyou.tvhall.api.TVhallApi;
import com.dwb.ruyou.tvhall.model.LiveShowItemBean;
import com.dwb.ruyou.tvhall.model.SearchList;
import com.dwb.ruyou.tvhall.model.SearchResultModel;
import com.dwb.ruyou.tvhall.ui.adapter.SearchAdapter;
import com.dwb.ruyou.tvhall.ui.widget.SearchKeyBoart;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvLinearLayoutManager;
import com.dwb.ruyou.tvhall.utils.RetrofitUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    private RelativeLayout search_keyboart_layout;
    private SearchKeyBoart searchKeyBoart;
    private RecyclerView tvRecyclerView;
    private SearchAdapter searchAdapter;
    private String searchKeyWord;//搜索关键字
    private TVhallApi tVhallApi;
    private Call<SearchList> searchListCall;
    private Call<SearchList> liveShowListCall;
    private List<SearchResultModel> resultModelList;
    private List<LiveShowItemBean> allWatchingList;//大家都在看就集合
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        tVhallApi= RetrofitUtils.getRestofitApi(ApiConfig.testUrl1,TVhallApi.class);
        liveShowListCall=tVhallApi.getAllWatching();
        resultModelList=new ArrayList<>();
        allWatchingList=new ArrayList<>();
        initView();
        getAllWatching();
    }

    private void initView() {
        search_keyboart_layout= (RelativeLayout) findViewById(R.id.search_keyboart_layout);
        searchKeyBoart= (SearchKeyBoart) findViewById(R.id.searchKeyboart_layout);
        tvRecyclerView= (RecyclerView) findViewById(R.id.search_rv);
//        tvRecyclerView.setKeyLeftNoItemListener(null,1);
        searchKeyBoart.searchStirngChange(new SearchKeyBoart.SearchChange() {
            @Override
            public void getSeachString(String s) {
                 searchKeyWord=s;
                if (!TextUtils.isEmpty(searchKeyWord)){
                    getSearchData();
                }else {
                    resultModelList.clear();
                    resultModelList.add(new SearchResultModel("all",null,allWatchingList));
                    if (searchAdapter!=null){
                        searchAdapter.updateItems(resultModelList);
                    }
                }
//                LogUtil.e("search","------searchKeyWord----"+searchKeyWord+"\n-------size-----"+allWatchingList.size());
            }
        });
        searchAdapter=new SearchAdapter(this);
        TvLinearLayoutManager tvLinearLayoutManager=new TvLinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        tvRecyclerView.setLayoutManager(tvLinearLayoutManager);
        tvRecyclerView.setAdapter(searchAdapter);
    }

    private void getSearchData(){
        searchListCall=tVhallApi.getSearchData(searchKeyWord);
        searchListCall.enqueue(new Callback<SearchList>() {
            @Override
            public void onResponse(Call<SearchList> call, Response<SearchList> response) {
                if (response.body()!=null&&"SUCCESS".equals(response.body().getResult())){
                    resultModelList.clear();
                    if ("1".equals(response.body().getTag())){
                        if (response.body().getCpGameList().size()>0){
                            resultModelList.add(new SearchResultModel("game",response.body().getCpGameList(),null));
                        }
                        if (response.body().getLivingShowRoomList().size()>0){
                            resultModelList.add(new SearchResultModel("liveShow",null,response.body().getLivingShowRoomList()));
                        }
                    }else if ("0".equals(response.body().getTag())){//没有搜索到内容
                        resultModelList.add(new SearchResultModel("nothing",null,response.body().getLivingShowRoomList()));
                    }
                    if (searchAdapter!=null){
                        searchAdapter.updateItems(resultModelList);
                    }
                }
            }

            @Override
            public void onFailure(Call<SearchList> call, Throwable t) {
                Toast.makeText(SearchActivity.this,"无法获取搜索信息!",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getAllWatching(){
        liveShowListCall.enqueue(new Callback<SearchList>() {
            @Override
            public void onResponse(Call<SearchList> call, Response<SearchList> response) {
                if (response.body()!=null&&"SUCCESS".equals(response.body().getResult())){
                    resultModelList.clear();
                    allWatchingList=response.body().getList();
                    resultModelList.add(new SearchResultModel("all",null,allWatchingList));
                    if (searchAdapter!=null){
                        searchAdapter.updateItems(resultModelList);
                    }
//                    LogUtil.e("search","------size----"+allWatchingList.size());
                }
            }

            @Override
            public void onFailure(Call<SearchList> call, Throwable t) {
                Toast.makeText(SearchActivity.this,"无法获取搜索信息!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_BACK:
                finish();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
}
