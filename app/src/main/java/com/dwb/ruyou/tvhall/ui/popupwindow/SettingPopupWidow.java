package com.dwb.ruyou.tvhall.ui.popupwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.dwb.ruyou.tvhall.R;

/**
 * Created by Slayer on 2017/6/29.
 * 获取设置界面的弹窗口的类
 */

public class SettingPopupWidow {

    /**联系我们的弹窗口*/
    public PopupWindow getContactPopupWidow(Context context){
        View view= LayoutInflater.from(context).inflate(R.layout.contact_popupwindow,null);
        PopupWindow contactPopupWindow=new PopupWindow(view,
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,false);
        ColorDrawable dw = new ColorDrawable(0x50000000);
        contactPopupWindow.setBackgroundDrawable(dw);
        contactPopupWindow.setFocusable(true);
        return contactPopupWindow;
    }



    /**帮助的弹窗口*/
    private ClickHelpImgListener clickHelpImgListener;
    public interface ClickHelpImgListener{
        void helpImgListener(View view,ImageView imageView,int i);
    }
    public void setClickHelpImgListener(ClickHelpImgListener clickHelpImgListener){
        this.clickHelpImgListener=clickHelpImgListener;
    }

    public  ImageView setting_help_img,setting_help_left_img,setting_help_right_img;
    public PopupWindow getHelpPopupWidow(Context context){
        View view= LayoutInflater.from(context).inflate(R.layout.help_popupwindow,null);
        PopupWindow helpPopupWindow=new PopupWindow(view,
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,false);
        ColorDrawable dw = new ColorDrawable(0x50000000);
        helpPopupWindow.setBackgroundDrawable(dw);
        helpPopupWindow.setFocusable(true);

        setting_help_img= (ImageView) view.findViewById(R.id.setting_help_img);
        setting_help_left_img= (ImageView) view.findViewById(R.id.setting_help_left_img);
        setting_help_right_img= (ImageView) view.findViewById(R.id.setting_help_right_img);

        setting_help_left_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickHelpImgListener.helpImgListener(view,setting_help_img,0);
            }
        });
        setting_help_right_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickHelpImgListener.helpImgListener(view,setting_help_img,1);
            }
        });
        return helpPopupWindow;
    }
}
