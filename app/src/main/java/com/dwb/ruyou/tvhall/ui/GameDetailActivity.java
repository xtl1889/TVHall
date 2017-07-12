package com.dwb.ruyou.tvhall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.api.ApiConfig;
import com.dwb.ruyou.tvhall.api.TVhallApi;
import com.dwb.ruyou.tvhall.model.GameDetail;
import com.dwb.ruyou.tvhall.ui.base.BaseActivity;
import com.dwb.ruyou.tvhall.utils.LogUtil;
import com.dwb.ruyou.tvhall.utils.RetrofitUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameDetailActivity extends BaseActivity {

    private TVhallApi tVhallApi;
    private Call<GameDetail> gameDetailCall;
    private String appKey;//游戏id
    private String gameType;//游戏类型
    private GameDetail gameDetail;

    private TextView game_detail_down_tv;
    private EditText game_detail_phone_num_et;
    private TextView game_detail_sure_tv;

    private SimpleDraweeView game_detail_img;
    private TextView game_detail_name_tv,game_detail_size_tv,game_detail_type_tv,game_detail_price_tv,
            game_detail_language_tv,game_detail_dwonNum_tv,game_detail_time_tv,game_detail_introduce_tv;
    private SimpleDraweeView game_detail_introduce_img1,game_detail_introduce_img2,game_detail_introduce_img3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);
        Intent intent=getIntent();
        if (intent!=null){
            appKey=intent.getStringExtra("appKey");
            gameType=intent.getStringExtra("gameType");
            LogUtil.e("gameDetail","----appKey----"+appKey);
        }
        initView();
        getGameData();
    }

    private void initView() {
        tVhallApi= RetrofitUtils.getRestofitApi(ApiConfig.testUrl1,TVhallApi.class);
        gameDetailCall=tVhallApi.getGameDetail(appKey);
        game_detail_down_tv= (TextView) findViewById(R.id.game_detail_down_tv);
        game_detail_phone_num_et= (EditText) findViewById(R.id.game_detail_phone_num_et);
        game_detail_sure_tv= (TextView) findViewById(R.id.game_detail_sure_tv);

        game_detail_img= (SimpleDraweeView) findViewById(R.id.game_detail_img);
        game_detail_size_tv= (TextView) findViewById(R.id.game_detail_size_tv);
        game_detail_name_tv= (TextView) findViewById(R.id.game_detail_name_tv);
        game_detail_type_tv= (TextView) findViewById(R.id.game_detail_type_tv);
        game_detail_price_tv= (TextView) findViewById(R.id.game_detail_price_tv);
        game_detail_language_tv= (TextView) findViewById(R.id.game_detail_language_tv);
        game_detail_dwonNum_tv= (TextView) findViewById(R.id.game_detail_dwonNum_tv);
        game_detail_time_tv= (TextView) findViewById(R.id.game_detail_time_tv);
        game_detail_introduce_tv= (TextView) findViewById(R.id.game_detail_introduce_tv);

        game_detail_introduce_img1= (SimpleDraweeView) findViewById(R.id.game_detail_introduce_img1);
        game_detail_introduce_img2= (SimpleDraweeView) findViewById(R.id.game_detail_introduce_img2);
        game_detail_introduce_img3= (SimpleDraweeView) findViewById(R.id.game_detail_introduce_img3);
    }

    private void getGameData() {
        if (!TextUtils.isEmpty(appKey)){
            gameDetailCall.enqueue(new Callback<GameDetail>() {
                @Override
                public void onResponse(Call<GameDetail> call, Response<GameDetail> response) {
                    if (response.body()!=null){
                        gameDetail=response.body();
                        LogUtil.e("gameDetail","---name---"+gameDetail.getGameName()+"---icon---"+gameDetail.getIcon());
                        setGameData();
                    }else {
                        Toast.makeText(GameDetailActivity.this,"获取游戏信息失败!",Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<GameDetail> call, Throwable t) {
                    Toast.makeText(GameDetailActivity.this,"请求游戏信息失败!",Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            Toast.makeText(this,"无法获取游戏信息!",Toast.LENGTH_SHORT).show();
        }
    }

    private void setGameData(){
        if (!TextUtils.isEmpty(gameDetail.getIcon())){
//            game_detail_img.setImageURI(ApiConfig.iconUrl+gameDetail.getIcon());
        }
        if (!TextUtils.isEmpty(gameDetail.getGameName())){
            game_detail_name_tv.setText(gameDetail.getGameName());
        }
        if (!TextUtils.isEmpty(gameDetail.getGameType())){
            game_detail_type_tv.setText(gameDetail.getGameType());
        }
        game_detail_dwonNum_tv.setText(String.valueOf(gameDetail.getDownloadNumber()));
        game_detail_size_tv.setText(gameDetail.getApkSize()+"M");
        if (!TextUtils.isEmpty(gameDetail.getGameBrief())){
            game_detail_introduce_tv.setText(gameDetail.getGameBrief());
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_BACK:
                Intent intent=new Intent();
                intent.putExtra("gameType",gameType);
                setResult(2,intent);
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
}
