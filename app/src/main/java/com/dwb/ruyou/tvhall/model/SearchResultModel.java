package com.dwb.ruyou.tvhall.model;

import java.util.List;

/**
 * Created by Slayer on 2017/7/7.
 */

public class SearchResultModel {
    private String tag;
    private List<GameItemBean> cpGameList;//搜索游戏结果
    private List<LiveShowItemBean> livingShowRoomList;//搜索直播结果

    public SearchResultModel(String tag, List<GameItemBean> cpGameList, List<LiveShowItemBean> livingShowRoomList) {
        this.tag = tag;
        this.cpGameList = cpGameList;
        this.livingShowRoomList = livingShowRoomList;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<GameItemBean> getCpGameList() {
        return cpGameList;
    }

    public void setCpGameList(List<GameItemBean> cpGameList) {
        this.cpGameList = cpGameList;
    }

    public List<LiveShowItemBean> getLivingShowRoomList() {
        return livingShowRoomList;
    }

    public void setLivingShowRoomList(List<LiveShowItemBean> livingShowRoomList) {
        this.livingShowRoomList = livingShowRoomList;
    }
}
