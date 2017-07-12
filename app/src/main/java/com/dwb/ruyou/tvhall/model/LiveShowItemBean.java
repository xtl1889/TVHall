package com.dwb.ruyou.tvhall.model;

/**
 * Created by Slayer on 2017/7/7.
 */

public class LiveShowItemBean {
    /**
     * id : 5
     * livingShowPlatform : 狮吼
     * livingShowPlatformUuid : a1
     * userName : a2
     * userAvatar : /asdasdf
     * livingShowRoomName : 123
     * audienceNumber : 0
     * isBroadcasting : 1
     * livingShowTypeId : 1
     * livingShowSubTypeId : 1
     * recommendRate : 5
     * img : /asd132
     */

    private int id;
    private String livingShowPlatform;
    private String livingShowPlatformUuid;
    private String userName;
    private String userAvatar;
    private String livingShowRoomName;
    private int audienceNumber;//观看人数
    private int isBroadcasting;
    private String livingShowTypeId;
    private String livingShowSubTypeId;
    private int recommendRate;
    private String img;

    private String tag;//首页 我的订阅 我的游戏标记
    private String viewTag;//首页 加载不同布局标记
    private boolean isShowDelectImg;//是否显示删除图标的标记

    public LiveShowItemBean() {
    }

    public LiveShowItemBean(String tag, String viewTag) {
        this.tag = tag;
        this.viewTag = viewTag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLivingShowPlatform() {
        return livingShowPlatform;
    }

    public void setLivingShowPlatform(String livingShowPlatform) {
        this.livingShowPlatform = livingShowPlatform;
    }

    public String getLivingShowPlatformUuid() {
        return livingShowPlatformUuid;
    }

    public void setLivingShowPlatformUuid(String livingShowPlatformUuid) {
        this.livingShowPlatformUuid = livingShowPlatformUuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getLivingShowRoomName() {
        return livingShowRoomName;
    }

    public void setLivingShowRoomName(String livingShowRoomName) {
        this.livingShowRoomName = livingShowRoomName;
    }

    public int getAudienceNumber() {
        return audienceNumber;
    }

    public void setAudienceNumber(int audienceNumber) {
        this.audienceNumber = audienceNumber;
    }

    public int getIsBroadcasting() {
        return isBroadcasting;
    }

    public void setIsBroadcasting(int isBroadcasting) {
        this.isBroadcasting = isBroadcasting;
    }

    public String getLivingShowTypeId() {
        return livingShowTypeId;
    }

    public void setLivingShowTypeId(String livingShowTypeId) {
        this.livingShowTypeId = livingShowTypeId;
    }

    public String getLivingShowSubTypeId() {
        return livingShowSubTypeId;
    }

    public void setLivingShowSubTypeId(String livingShowSubTypeId) {
        this.livingShowSubTypeId = livingShowSubTypeId;
    }

    public int getRecommendRate() {
        return recommendRate;
    }

    public void setRecommendRate(int recommendRate) {
        this.recommendRate = recommendRate;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getViewTag() {
        return viewTag;
    }

    public void setViewTag(String viewTag) {
        this.viewTag = viewTag;
    }

    public boolean isShowDelectImg() {
        return isShowDelectImg;
    }

    public void setShowDelectImg(boolean showDelectImg) {
        isShowDelectImg = showDelectImg;
    }
}
