package com.dwb.ruyou.tvhall.api;

import com.dwb.ruyou.tvhall.model.GameDetail;
import com.dwb.ruyou.tvhall.model.GameList;
import com.dwb.ruyou.tvhall.model.GameTitle;
import com.dwb.ruyou.tvhall.model.GoldInfo;
import com.dwb.ruyou.tvhall.model.LiveShowList;
import com.dwb.ruyou.tvhall.model.LiveShowTitle;
import com.dwb.ruyou.tvhall.model.RecommendModel;
import com.dwb.ruyou.tvhall.model.SearchList;
import com.dwb.ruyou.tvhall.model.SmsCode;
import com.dwb.ruyou.tvhall.model.TestModel;
import com.dwb.ruyou.tvhall.model.TestModel_post;
import com.dwb.ruyou.tvhall.model.UserLoginInfo;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

/**
 * Created by Slayer on 2017/6/6.
 */

public interface TVhallApi {

    /**
    *************测试接口************************
    * */
    @GET("requestAndroidVersion")
    Call<TestModel> getTestData1();

    @GET("blog/{id}")
    Call<ResponseBody> getBlog(@Path("id") int id);

    @GET("tiyu/tiyu")
    Call<ResponseBody> Cheshi(
            @Query("num") String num,
            @Query("page") String page
    );

    /**
    * @FormUrlEncoded注解来发送表单数据。使用 @Field注解和参数来指定每个表单项的Key，value为参数的值。
    * */
    @FormUrlEncoded
    @POST("update/getUpdateGame")
    Call<TestModel_post> getTestData2(@Field("appKey")String appKey,
                                      @Field("channelCode") String channelCode);

    /**
     * 当我们有很多个表单参数时可以通过@FieldMap注解和Map对象参数来指定每个表单项的Key，value的值。
     * */
    @FormUrlEncoded
    @POST("getUpdateGame")
    Call<TestModel_post> getTestData22(@FieldMap Map<String,String> map);

    /**
     * 下载文件
     * */
    @Streaming
    @GET("t_test/梦中旅人-联网版TV.apk")
    Call<ResponseBody> downLoadFile();

//    @Streaming
//    @GET("t_test/梦中旅人-联网版TV.apk")
//    Observable<ResponseBody> downLoadFile2();

    /**
     * ******************************正式接口地址********************************************
     * */

    /**
     * 获取验证码
     * phone 手机号
     * sign  phone+cuoehINOoy5SqERdMh2OXZnceYEU3zA   md5加密字符串
     * */
    @FormUrlEncoded
    @POST("personalUser/smsCode")
    Call<SmsCode> getSmsCode(@Field("phone")String phone,
                             @Field("sign") String sign);

    /**
     * 登录或者注册接口
     * phone 手机号
     * smsCode 验证码
     * */
    @FormUrlEncoded
    @POST("personalUser/registerOrLogin")
    Call<UserLoginInfo> useRegisterOrLogin(@Field("phone")String phone,
                                           @Field("smsCode") String smsCode);

    /**
     * 充值金币的信息
     * */
    @GET("dwbMoney/getDwbChargeMenu")
    Call<GoldInfo> goldInfo();

    /**
     * 游戏分类 标题
     * */
    @GET("tvMarket/getAllTVGameType")
    Call<GameTitle> getGameTitle();

    /**
     * 游戏列表
     * */
    @GET("tvMarket/getTVGameList")
    Call<GameList> getTVGameList(@Query("gameType") String gameType);


    /**
     * 游戏详情
     * */
    @FormUrlEncoded
    @POST("tvMarket/getGameDetail")
    Call<GameDetail> getGameDetail(@Field("appKey")String appKey);

    /**
     * 搜索
     * */
    @FormUrlEncoded
    @POST("tvMarket/searchTVMarket")
    Call<SearchList> getSearchData(@Field("content")String content);

    /**
     * 大家都在看
     * */
    @GET("tvMarket/getAllWatchingRoomList")
    Call<SearchList> getAllWatching();

    /**
     * 首页推荐界面信息
     * */
    @GET("tvMarket/getHomePageInfo")
    Call<RecommendModel> getHomePageInfo();


    /**
     * 直播分类 标题
     * */
    @GET("tvMarket/getAllLivingShowGame")
    Call<LiveShowTitle> getLiveShowTitle();

    /**
     * 直播列表
     * */
    @GET("tvMarket/getLivingShowRoomList")
    Call<LiveShowList> getLiveShowList(@Query("gameId") long gameId);

}
