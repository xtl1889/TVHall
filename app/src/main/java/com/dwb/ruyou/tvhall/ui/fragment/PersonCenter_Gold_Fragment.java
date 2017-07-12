package com.dwb.ruyou.tvhall.ui.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.api.ApiConfig;
import com.dwb.ruyou.tvhall.api.TVhallApi;
import com.dwb.ruyou.tvhall.application.TVHallApplication;
import com.dwb.ruyou.tvhall.model.GoldInfo;
import com.dwb.ruyou.tvhall.model.SmsCode;
import com.dwb.ruyou.tvhall.model.UserLoginInfo;
import com.dwb.ruyou.tvhall.ui.PayChenterActivity;
import com.dwb.ruyou.tvhall.ui.base.BaseFragment;
import com.dwb.ruyou.tvhall.utils.InputMethodUtils;
import com.dwb.ruyou.tvhall.utils.LogUtil;
import com.dwb.ruyou.tvhall.utils.MD5;
import com.dwb.ruyou.tvhall.utils.RetrofitUtils;
import com.dwb.ruyou.tvhall.utils.SystemTools;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * 我的金币界面
 */
public class PersonCenter_Gold_Fragment extends BaseFragment implements View.OnFocusChangeListener,View.OnClickListener,View.OnKeyListener{
    private boolean isLogin;
    private LinearLayout gold_urer_login_layout,gold_urer_info_layout;
    private EditText playGold_phoneNum_et,playGold_checkCode_et;
    private TextView gold_get_smsCode,gold_userlogin_tv,gold_changeuser_tv;
    private LinearLayout gold1_info_layout,gold_gold11_layout,gold_gold12_layout,gold_gold21_layout,gold_gold22_layout;
    private String phoneNmu,smsCode;//手机号  验证码
    private TextView user_gold_tv1,user_addGold_tv1,user_payRmb_tv1,
            user_gold_tv2,user_addGold_tv2,user_payRmb_tv2,
            user_gold_tv3,user_addGold_tv3,user_payRmb_tv3,
            user_gold_tv4,user_addGold_tv4,user_payRmb_tv4,
            user_gold_tv5,user_addGold_tv5,user_payRmb_tv5;

    private boolean phone_et_focus,smsCode_et_focus;//手机号 验证码的EditText是否获取焦点
    private TVhallApi tVhallApi;
    private Call<SmsCode> smsCodeCall;
    private Call<UserLoginInfo> userLoginInfoCall;
    private Call<GoldInfo> goldInfoCall;
    private GoldInfo goldInfo;

    public PersonCenter_Gold_Fragment() {
        // Required empty public constructor
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_person_center__gold_;
    }

    @Override
    public void initView() {
        super.initView();
        isLogin= TVHallApplication.isLogin;
        tVhallApi= RetrofitUtils.getRestofitApi(ApiConfig.testUrl1,TVhallApi.class);
        goldInfoCall=tVhallApi.goldInfo();

        gold_urer_login_layout= (LinearLayout) view.findViewById(R.id.gold_urer_login_layout);
        gold_urer_info_layout= (LinearLayout) view.findViewById(R.id.gold_urer_info_layout);
        if (!isLogin){
            gold_urer_info_layout.setVisibility(View.GONE);
            gold_urer_login_layout.setVisibility(View.VISIBLE);
        }else {
            gold_urer_info_layout.setVisibility(View.VISIBLE);
            gold_urer_login_layout.setVisibility(View.GONE);
        }

        playGold_phoneNum_et= (EditText) view.findViewById(R.id.playGold_phoneNum_et);
        playGold_phoneNum_et.setOnFocusChangeListener(this);
        playGold_phoneNum_et.setOnKeyListener(this);
        playGold_checkCode_et= (EditText) view.findViewById(R.id.playGold_checkCode_et);
        playGold_checkCode_et.setOnFocusChangeListener(this);
        playGold_checkCode_et.setOnClickListener(this);

        gold_get_smsCode= (TextView) view.findViewById(R.id.gold_get_smsCode);
        gold_get_smsCode.setOnFocusChangeListener(this);
        gold_get_smsCode.setOnClickListener(this);
        gold_userlogin_tv= (TextView) view.findViewById(R.id.gold_userlogin_tv);
        gold_userlogin_tv.setOnFocusChangeListener(this);
        gold_userlogin_tv.setOnClickListener(this);
        gold_changeuser_tv= (TextView) view.findViewById(R.id.gold_changeuser_tv);
        gold_changeuser_tv.setOnFocusChangeListener(this);
        gold_changeuser_tv.setOnClickListener(this);

        gold1_info_layout= (LinearLayout) view.findViewById(R.id.gold1_info_layout);
        gold1_info_layout.setOnFocusChangeListener(this);
        gold1_info_layout.setOnClickListener(this);
        gold_gold11_layout= (LinearLayout) view.findViewById(R.id.gold_gold11_layout);
        gold_gold11_layout.setOnFocusChangeListener(this);
        gold_gold11_layout.setOnClickListener(this);
        gold_gold12_layout= (LinearLayout) view.findViewById(R.id.gold_gold12_layout);
        gold_gold12_layout.setOnFocusChangeListener(this);
        gold_gold12_layout.setOnClickListener(this);
        gold_gold21_layout= (LinearLayout) view.findViewById(R.id.gold_gold21_layout);
        gold_gold21_layout.setOnFocusChangeListener(this);
        gold_gold21_layout.setOnClickListener(this);
        gold_gold22_layout= (LinearLayout) view.findViewById(R.id.gold_gold22_layout);
        gold_gold22_layout.setOnFocusChangeListener(this);
        gold_gold22_layout.setOnClickListener(this);
        keyUpDeal(playGold_phoneNum_et);
        getGoldInfo();
    }

    private void addGoldTextView() {
        user_gold_tv1= (TextView) view.findViewById(R.id.user_gold_tv1);
        user_addGold_tv1= (TextView) view.findViewById(R.id.user_addGold_tv1);
        user_payRmb_tv1= (TextView) view.findViewById(R.id.user_payRmb_tv1);

        user_gold_tv2= (TextView) view.findViewById(R.id.user_gold_tv2);
        user_addGold_tv2= (TextView) view.findViewById(R.id.user_addGold_tv2);
        user_payRmb_tv2= (TextView) view.findViewById(R.id.user_payRmb_tv2);

        user_gold_tv3= (TextView) view.findViewById(R.id.user_gold_tv3);
        user_addGold_tv3= (TextView) view.findViewById(R.id.user_addGold_tv3);
        user_payRmb_tv3= (TextView) view.findViewById(R.id.user_payRmb_tv3);

        user_gold_tv4= (TextView) view.findViewById(R.id.user_gold_tv4);
        user_addGold_tv4= (TextView) view.findViewById(R.id.user_addGold_tv4);
        user_payRmb_tv4= (TextView) view.findViewById(R.id.user_payRmb_tv4);

        user_gold_tv5= (TextView) view.findViewById(R.id.user_gold_tv5);
        user_addGold_tv5= (TextView) view.findViewById(R.id.user_addGold_tv5);
        user_payRmb_tv5= (TextView) view.findViewById(R.id.user_payRmb_tv5);
        if (goldInfo!=null&&goldInfo.getList().size()>=5){
            user_gold_tv1.setText("×"+goldInfo.getList().get(0).getChargeMoney()/10);
            user_addGold_tv1.setText(String.valueOf(goldInfo.getList().get(0).getDeliverMoney()/10));
            user_payRmb_tv1.setText(setGoldText(goldInfo.getList().get(0).getChargeMoney()/100));

            user_gold_tv2.setText("×"+goldInfo.getList().get(1).getChargeMoney()/10);
            user_addGold_tv2.setText(String.valueOf(goldInfo.getList().get(1).getDeliverMoney()/10));
            user_payRmb_tv2.setText(setGoldText(goldInfo.getList().get(1).getChargeMoney()/100));

            user_gold_tv3.setText("×"+goldInfo.getList().get(2).getChargeMoney()/10);
            user_addGold_tv3.setText(String.valueOf(goldInfo.getList().get(2).getDeliverMoney()/10));
            user_payRmb_tv3.setText(setGoldText(goldInfo.getList().get(2).getChargeMoney()/100));

            user_gold_tv4.setText("×"+goldInfo.getList().get(3).getChargeMoney()/10);
            user_addGold_tv4.setText(String.valueOf(goldInfo.getList().get(3).getDeliverMoney()/10));
            user_payRmb_tv4.setText(setGoldText(goldInfo.getList().get(3).getChargeMoney()/100));

            user_gold_tv5.setText("×"+goldInfo.getList().get(4).getChargeMoney()/10);
            user_addGold_tv5.setText(String.valueOf(goldInfo.getList().get(4).getDeliverMoney()/10));
            user_payRmb_tv5.setText(setGoldText(goldInfo.getList().get(4).getChargeMoney()/100));
        }

    }


    private String setGoldText(int i){
        DecimalFormat df=new DecimalFormat("#.00");
        return "¥ "+df.format((double) i);
    }
    /**
     * 拦截按向上键时  焦点变化
     * */
    private void keyUpDeal(View view){
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (i) {
                        case KeyEvent.KEYCODE_DPAD_UP:
                            return true;
//                            break;
                    }
                }
                return false;
            }
        });
    }
    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()){
            case R.id.playGold_phoneNum_et:
                if (b){
                    phone_et_focus=true;
                }else {
                    phone_et_focus=false;
                }
                break;
            case R.id.playGold_checkCode_et:
                if (b){
                    smsCode_et_focus=true;
                }else {
                    smsCode_et_focus=false;
                }
                break;
            case R.id.gold_get_smsCode:
                if (b){
                    gold_get_smsCode.setTextColor(getResources().getColor(R.color.keyboart_select_item_stroke));
                }else {
                    gold_get_smsCode.setTextColor(getResources().getColor(R.color.text_white));
                }
                break;
        }

        if (!smsCode_et_focus&&!phone_et_focus){
//            InputMethodUtils.hideSoftInput(mContext);//隐藏软键盘
        }else {
            InputMethodUtils.showInputMethod(mContext);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.gold_get_smsCode:
                getSmsCode();
                break;
            case R.id.gold_userlogin_tv:
                userRegisterOrLogin();
                break;
            case R.id.gold_changeuser_tv:
//                gold_urer_info_layout.setVisibility(View.GONE);
//                gold_urer_login_layout.setVisibility(View.VISIBLE);
                TVHallApplication.isLogin=false;
                restartActivity();
                break;
            case R.id.gold1_info_layout:
                startActivity(new Intent(mContext, PayChenterActivity.class));
                break;
            case R.id.gold_gold11_layout:
                startActivity(new Intent(mContext, PayChenterActivity.class));
                break;
            case R.id.gold_gold12_layout:
                startActivity(new Intent(mContext, PayChenterActivity.class));
                break;
            case R.id.gold_gold21_layout:
                startActivity(new Intent(mContext, PayChenterActivity.class));
                break;
            case R.id.gold_gold22_layout:
                startActivity(new Intent(mContext, PayChenterActivity.class));
                break;
        }
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        switch (view.getId()){
            case R.id.playGold_checkCode_et:
//                if (i==)
                break;
        }
        return false;
    }

    //获取手机验证码
    private void getSmsCode(){
        phoneNmu=playGold_phoneNum_et.getText().toString();
        if (TextUtils.isEmpty(phoneNmu)){
            Toast.makeText(mContext,"手机号码为空，请重新输入!",Toast.LENGTH_SHORT).show();
        }else {
            if (!SystemTools.isMobileNO(phoneNmu)){
                Toast.makeText(mContext,"手机号码格式不正确,请重新输入!",Toast.LENGTH_SHORT).show();
            }else {
                String sign= MD5.GetMD5Code("phone="+phoneNmu+"cuoehINOoy5SqERdMh2OXZnceYEU3zAj");
//                Log.e("user", "getSmsCode: ---phone---"+phoneNmu+"\n---sign--"+sign );
                smsCodeCall=tVhallApi.getSmsCode(phoneNmu,sign);
                smsCodeCall.enqueue(new Callback<SmsCode>() {
                    @Override
                    public void onResponse(Call<SmsCode> call, Response<SmsCode> response) {
                        if (response.body()!=null){
                             LogUtil.e("user", "onResponse: ---smscode---"+response.body());
                            if ("Fail".equals(response.body().getResult())&&!TextUtils.isEmpty(response.body().getMsg())){
                                Toast.makeText(mContext,response.body().getMsg(),Toast.LENGTH_SHORT).show();
                            }else if ("SUCCESS".equals(response.body().getResult())){
                                Toast.makeText(mContext,"获取验证码成功,请注意查收!",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<SmsCode> call, Throwable t) {
                        Toast.makeText(mContext,"获取验证码失败",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }
    //用户登录
    private void userRegisterOrLogin(){
        smsCode=playGold_checkCode_et.getText().toString();
        if (TextUtils.isEmpty(smsCode)){
            Toast.makeText(mContext,"验证码为空，请重新输入!",Toast.LENGTH_SHORT).show();
        }else {
            userLoginInfoCall=tVhallApi.useRegisterOrLogin(phoneNmu,smsCode);
            userLoginInfoCall.enqueue(new Callback<UserLoginInfo>() {
                @Override
                public void onResponse(Call<UserLoginInfo> call, Response<UserLoginInfo> response) {
                    if (response.body()!=null&&"SUCCESS".equals(response.body().getResult())){
                        LogUtil.e("user", "onResponse: ---login----"+response.body() );
                        TVHallApplication.isLogin=true;
//                        gold_urer_info_layout.setVisibility(View.VISIBLE);
//                        gold_urer_login_layout.setVisibility(View.GONE);
                        restartActivity();
                    }else {
                        Toast.makeText(mContext,response.body().getMsg(),Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<UserLoginInfo> call, Throwable t) {
                    Toast.makeText(mContext,"登录失败!",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void restartActivity(){
        Intent intern=getActivity().getIntent();
        intern.putExtra("showFragmentTag",3);
        getActivity().finish();
        startActivity(intern);
    }

    //获取充值金币信息
    private void getGoldInfo(){
        goldInfoCall.enqueue(new Callback<GoldInfo>() {
            @Override
            public void onResponse(Call<GoldInfo> call, Response<GoldInfo> response) {
                if (response.body()!=null&&"SUCCESS".equals(response.body().getResult())){
                    goldInfo=response.body();
                    addGoldTextView();
                    LogUtil.e("goldInfo","-----"+goldInfo.toString());
                }else {
                    Toast.makeText(mContext,"获取充值金币信息失败!",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GoldInfo> call, Throwable t) {
                Toast.makeText(mContext,"无法获取充值金币信息!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
