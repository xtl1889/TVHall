package com.dwb.ruyou.tvhall.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.api.ApiConfig;
import com.dwb.ruyou.tvhall.api.TVhallApi;
import com.dwb.ruyou.tvhall.model.GameList;
import com.dwb.ruyou.tvhall.model.eventbusmodel.MainToTabRequesfous;
import com.dwb.ruyou.tvhall.ui.GameDetailActivity;
import com.dwb.ruyou.tvhall.ui.adapter.Game_all_adapter;
import com.dwb.ruyou.tvhall.ui.base.BaseFragment;
import com.dwb.ruyou.tvhall.ui.widget.RecyclerViewTV;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvGridLayoutManager;
import com.dwb.ruyou.tvhall.ui.widget.recyclerview1.TvRecyclerView;
import com.dwb.ruyou.tvhall.utils.LogUtil;
import com.dwb.ruyou.tvhall.utils.RetrofitUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Slayer on 2017/6/15.
 */

public class Game_All_Fragment extends BaseFragment{
    private RecyclerViewTV recyclerViewTV;
    private TvRecyclerView tvRecyclerView;
    private View parentUpView;
    private Game_all_adapter adapter;

    private TVhallApi tVhallApi;
    private Call<GameList> gameListCall;
    private String gameType;//游戏类型

    public Game_All_Fragment(View parentUpView) {
        this.parentUpView = parentUpView;
    }

    public Game_All_Fragment() {
    }

    public Game_All_Fragment(String gameType) {
        this.gameType = gameType;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_game__all_;
    }

    Game_all_adapter.ClickItmeListener clickItmeListener=new Game_all_adapter.ClickItmeListener() {
        @Override
        public void clickItem(View view, int pos, String appKey,String gameType) {
            Intent intent=new Intent(getActivity(), GameDetailActivity.class);
            intent.putExtra("appKey",appKey);
            intent.putExtra("gameType",gameType);
            getActivity().startActivityForResult(intent,1);
            focusView=view;
//                startActivityForResult(intent,1);
        }
    };

    @Override
    public void initView() {
        super.initView();
        tVhallApi= RetrofitUtils.getRestofitApi(ApiConfig.testUrl1,TVhallApi.class);
        gameListCall=tVhallApi.getTVGameList(gameType);

        recyclerViewTV= (RecyclerViewTV) view.findViewById(R.id.game_all_recycler);
        tvRecyclerView= (TvRecyclerView) view.findViewById(R.id.game_all_recycler2);

//        GridLayoutManager gridLayoutManager=new GridLayoutManager(mContext,4,GridLayoutManager.VERTICAL,false);
//        recyclerViewTV.setLayoutManager(gridLayoutManager);
//        recyclerViewTV.setAdapter(adapter);

        tvRecyclerView.setFocusable(false);
        tvRecyclerView.setItemAnimator(null);
        TvGridLayoutManager tvGridLayoutManager=new TvGridLayoutManager(mContext,4);
        tvGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        adapter=new Game_all_adapter(mContext,tvRecyclerView);

        tvRecyclerView.setLayoutManager(tvGridLayoutManager);
        tvRecyclerView.setSelectedItemOffset(180,180);
        tvRecyclerView.setAdapter(adapter);
//        adapter.addItems(creadData());
        adapter.setClickItemListener(clickItmeListener);
        getGameData();

    }

    private void getGameData() {
        gameListCall.enqueue(new Callback<GameList>() {
            @Override
            public void onResponse(Call<GameList> call, Response<GameList> response) {
                if (response.body()!=null&&response.body().getTvGameList().size()>0){
                    adapter.addItems(response.body().getTvGameList());
                }else {
                    Toast.makeText(mContext,"获取游戏列表失败!",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GameList> call, Throwable t) {
                Toast.makeText(mContext,"无法获取游戏列表!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<String> creadData(){
        List<String> list=new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add("游戏--"+i);
        }
        return list;
    }


    @Subscribe(threadMode = ThreadMode.POSTING) // ThreadMode is optional here
    public void onMessage(MainToTabRequesfous requesfous) {
//        Log.e("keyDown", "onMessage: -----game_all_Fragment-----"+requesfous.toString() );
//        if (requesfous!=null&&requesfous.isReques()){
////            tvRecyclerView.clearFocus();
////            recyclerViewTV.clearChildFocus();
//        }
    }

   public boolean onKeyDown(int keyCode, KeyEvent event){
       switch (keyCode){

           case KeyEvent.KEYCODE_DPAD_DOWN:
               Log.e("keyDown", "-----gameFragment: --down---"+keyCode );
               break;
       }

       return false;
   }

   private View focusView;
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==2&&requestCode==1){
            String s=data.getStringExtra("gameType");
//            focusView.requestFocus();
            LogUtil.e("gameTitle", "onActivityResult: -----fragment----"+s);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
