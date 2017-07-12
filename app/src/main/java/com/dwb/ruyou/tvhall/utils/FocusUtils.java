package com.dwb.ruyou.tvhall.utils;

import android.view.View;
import android.view.ViewTreeObserver;

/**
 * Created by Slayer on 2017/7/4.
 * 代码中设置焦点的工具类
 * 当view没有绘制出出来时  requestFocus()方法不起作用
 * 这里做一个监听 当view绘制出来后 设置该方法
 */

public class FocusUtils {

    public static boolean setViewFocus(final View view,boolean isFocus){
        if (!isFocus){
            ViewTreeObserver viewTreeObserver=view.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    view.requestFocus();
                }
            });
        }
        return true;
    }
}
