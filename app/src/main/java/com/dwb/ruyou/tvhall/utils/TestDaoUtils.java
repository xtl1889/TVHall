package com.dwb.ruyou.tvhall.utils;

import com.dwb.ruyou.tvhall.application.TVHallApplication;
import com.dwb.ruyou.tvhall.model.DaoModel.TestModel;

import java.util.List;

/**
 * Created by Slayer on 2017/7/10.
 */

public class TestDaoUtils {

    public static void insertTest(TestModel testModel){
        TVHallApplication.getDaoInstance().getTestModelDao().insert(testModel);
    }

    public static void deleteTest(long id){
        TVHallApplication.getDaoInstance().getTestModelDao().deleteByKey(id);
    }

    public static void updateTest(TestModel testModel){
        TVHallApplication.getDaoInstance().getTestModelDao().update(testModel);
    }

    public static List<TestModel> queryAll(){
        return TVHallApplication.getDaoInstance().getTestModelDao().loadAll();
    }



    /**
     * 查询条件为Type=TYPE_LOVE的数据
     *
     * @return
     */
//    public static List<Shop> queryLove() {
//        return BaseApplication.getDaoInstant().getShopDao().queryBuilder().where(ShopDao.Properties.Type.eq(Shop.TYPE_LOVE)).list();
//    }



}
