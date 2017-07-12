package com.dwb.ruyou.tvhall.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Slayer on 2017/7/5.
 */

public class OutputUtils {
    public static void toast(String s, Context c){
        Toast.makeText(c,s,Toast.LENGTH_SHORT).show();
    }
}
