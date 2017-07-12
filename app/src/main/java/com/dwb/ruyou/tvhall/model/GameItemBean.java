package com.dwb.ruyou.tvhall.model;

/**
 * Created by Slayer on 2017/7/7.
 */

public class GameItemBean {
    /**
     * id : 1
     * gameName : 梦中旅人
     * gameUuid : mengzhonglvren
     * cpUuid : bingyu
     * appKey : dream
     * updateTime : 1494405995000
     * isRecommandTvMarket : 1
     * star : 0                       //星级
     * apkSize : 35.56
     * icon : /icon/dream-icon.png   //图片  https://user-update.ru-you.com/ icon/dream-icon.png
     * gameType : 音乐跑酷
     * downloadNumber : 1
     * gameVersion : 1.3.0
     */

    private int id;
    private String gameName;
    private String gameUuid;
    private String cpUuid;
    private String appKey;
    private long updateTime;
    private int isRecommandTvMarket;
    private int star;
    private double apkSize;
    private String icon;
    private String gameType;
    private int downloadNumber;
    private String gameVersion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameUuid() {
        return gameUuid;
    }

    public void setGameUuid(String gameUuid) {
        this.gameUuid = gameUuid;
    }

    public String getCpUuid() {
        return cpUuid;
    }

    public void setCpUuid(String cpUuid) {
        this.cpUuid = cpUuid;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public int getIsRecommandTvMarket() {
        return isRecommandTvMarket;
    }

    public void setIsRecommandTvMarket(int isRecommandTvMarket) {
        this.isRecommandTvMarket = isRecommandTvMarket;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public double getApkSize() {
        return apkSize;
    }

    public void setApkSize(double apkSize) {
        this.apkSize = apkSize;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public int getDownloadNumber() {
        return downloadNumber;
    }

    public void setDownloadNumber(int downloadNumber) {
        this.downloadNumber = downloadNumber;
    }

    public String getGameVersion() {
        return gameVersion;
    }

    public void setGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
    }
}
