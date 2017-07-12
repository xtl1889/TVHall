package com.dwb.ruyou.tvhall.application;

import android.database.sqlite.SQLiteDatabase;
import android.support.multidex.MultiDexApplication;

import com.dwb.ruyou.tvhall.model.DaoModel.DaoMaster;
import com.dwb.ruyou.tvhall.model.DaoModel.DaoSession;
import com.dwb.ruyou.tvhall.utils.LogUtils;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Slayer on 2017/6/8.
 */

public class TVHallApplication extends MultiDexApplication {
    public static TVHallApplication sInstance;
    public static DaoSession daoSession;
    public static boolean isLogin=false;//用户是否登录
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        LogUtils.initializeLogger();
        sInstance=this;
        setDataBase();
    }

    public static synchronized TVHallApplication getTVHallInstance() {
        return sInstance;
    }

    private void setDataBase(){
        DaoMaster.DevOpenHelper devOpenHelper=new DaoMaster.DevOpenHelper(this,"tvHall.db",null);
        SQLiteDatabase sqLiteDatabase=devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster=new DaoMaster(sqLiteDatabase);
        daoSession=daoMaster.newSession();
    }
    public static DaoSession getDaoInstance(){
        return daoSession;
    }
}
