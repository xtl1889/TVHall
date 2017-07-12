package com.dwb.ruyou.tvhall.utils;

import android.view.View;
import android.view.ViewTreeObserver;

/**
 * Created by Slayer on 2017/7/7.
 */

public class SetWeightHeightUtils {

    public static boolean setWeight(final View view, boolean b){
        if (!b){
            ViewTreeObserver viewTreeObserver=view.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                }
            });
        }

        return true;
    }
}
