package com.dwb.ruyou.tvhall.model;

import java.util.List;

/**
 * Created by Slayer on 2017/7/11.
 */

public class HomeModel {
    private String tag;
    private List<LiveShowItemBean> livingShowRoomList;
    private List<RecommendClassiedBean> livingShowGameList;
    private List<GameItemBean> cpGameList;

    public HomeModel(String tag, List<LiveShowItemBean> livingShowRoomList, List<RecommendClassiedBean> livingShowGameList, List<GameItemBean> cpGameList) {
        this.tag = tag;
        this.livingShowRoomList = livingShowRoomList;
        this.livingShowGameList = livingShowGameList;
        this.cpGameList = cpGameList;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<LiveShowItemBean> getLivingShowRoomList() {
        return livingShowRoomList;
    }

    public void setLivingShowRoomList(List<LiveShowItemBean> livingShowRoomList) {
        this.livingShowRoomList = livingShowRoomList;
    }

    public List<RecommendClassiedBean> getLivingShowGameList() {
        return livingShowGameList;
    }

    public void setLivingShowGameList(List<RecommendClassiedBean> livingShowGameList) {
        this.livingShowGameList = livingShowGameList;
    }

    public List<GameItemBean> getCpGameList() {
        return cpGameList;
    }

    public void setCpGameList(List<GameItemBean> cpGameList) {
        this.cpGameList = cpGameList;
    }
}
