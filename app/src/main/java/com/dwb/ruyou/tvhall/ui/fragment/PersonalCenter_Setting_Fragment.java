package com.dwb.ruyou.tvhall.ui.fragment;


import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.dwb.ruyou.tvhall.R;
import com.dwb.ruyou.tvhall.ui.base.BaseFragment;
import com.dwb.ruyou.tvhall.ui.popupwindow.SettingPopupWidow;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalCenter_Setting_Fragment extends BaseFragment implements View.OnClickListener{
    private LinearLayout personal_setting_layout;
    private LinearLayout setting_contact_layout,setting_help_layout,setting_update_layout;
    private SettingPopupWidow settingPopupWidow;
    private PopupWindow contactPopupWindow,helpPopupWindow;
    private int helpImagTag=0;
    private ArrayList<Integer> helpImageIdList;//帮助页面的图片
    public PersonalCenter_Setting_Fragment() {
        // Required empty public constructor
    }


    @Override
    public int getViewId() {
        return R.layout.fragment_personal_center__setting_;
    }

    @Override
    public void initView() {
        super.initView();
        personal_setting_layout= (LinearLayout) view.findViewById(R.id.personal_setting_layout);
        setting_contact_layout= (LinearLayout) view.findViewById(R.id.setting_contact_layout);
        setting_contact_layout.setOnClickListener(this);
        setting_help_layout= (LinearLayout) view.findViewById(R.id.setting_help_layout);
        setting_help_layout.setOnClickListener(this);
        setting_update_layout= (LinearLayout) view.findViewById(R.id.setting_update_layout);
        setting_update_layout.setOnClickListener(this);
        keyUpDeal(setting_contact_layout);
        keyUpDeal(setting_help_layout);
        keyUpDeal(setting_update_layout);
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
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.setting_contact_layout:
                if (contactPopupWindow==null){
                    showPopupWindow(0);
                }else {
                    if (!contactPopupWindow.isShowing()){
                        contactPopupWindow.showAtLocation(personal_setting_layout, Gravity.CENTER,0,0);
                    }else {
                        contactPopupWindow.dismiss();
                    }
                }
                break;
            case R.id.setting_help_layout:
                if (helpPopupWindow==null){
                    showPopupWindow(1);
                }else {
                    if (!helpPopupWindow.isShowing()){
                        helpPopupWindow.showAtLocation(personal_setting_layout, Gravity.CENTER,0,0);
                        settingPopupWidow.setting_help_left_img.requestFocus();
                    }else {
                        helpPopupWindow.dismiss();
                    }
                }
                break;
            case R.id.setting_update_layout:
                break;
        }
    }

    private void showPopupWindow(int type){
        if (settingPopupWidow==null){
            settingPopupWidow=new SettingPopupWidow();
            settingPopupWidow.setClickHelpImgListener(clickHelpImgListener);
        }

        if (type==0){
            contactPopupWindow=settingPopupWidow.getContactPopupWidow(mContext);
            contactPopupWindow.showAtLocation(personal_setting_layout, Gravity.CENTER,0,0);
        }else if (type==1){
            saveHelpImgId();
            helpPopupWindow=settingPopupWidow.getHelpPopupWidow(mContext);
            helpPopupWindow.showAtLocation(personal_setting_layout, Gravity.CENTER,0,0);
            settingPopupWidow.setting_help_left_img.requestFocus();
        }
    }

    private void saveHelpImgId(){
        if (helpImageIdList==null){
            helpImageIdList=new ArrayList<>();
        }
        helpImageIdList.add(R.drawable.settings1);
        helpImageIdList.add(R.drawable.settings2);
        helpImageIdList.add(R.drawable.settings3);
    }
    //帮助弹出框  点击左右按钮的监听
    private SettingPopupWidow.ClickHelpImgListener clickHelpImgListener=new SettingPopupWidow.ClickHelpImgListener() {
        @Override
        public void helpImgListener(View view, ImageView imageView, int i) {
            if (i==0){
                if (helpImagTag<=0)return;
                helpImagTag--;
            }else if (i==1){
                if (helpImagTag>=2)return;
                helpImagTag++;
            }
            imageView.setImageResource(helpImageIdList.get(helpImagTag));
        }
    };
}
