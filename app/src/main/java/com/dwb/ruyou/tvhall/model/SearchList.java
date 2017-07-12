package com.dwb.ruyou.tvhall.model;

import java.util.List;

/**
 * Created by Slayer on 2017/7/7.
 */

public class SearchList {

    /**
     * result : SUCCESS
     * cpGameList : []
     * livingShowRoomList : []
     */

    private String result;
    private String tag;
    private List<GameItemBean> cpGameList;//搜索游戏结果
    private List<LiveShowItemBean> livingShowRoomList;//搜索直播结果
    private List<LiveShowItemBean> list;//首次进入的直播列表

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<LiveShowItemBean> getList() {
        return list;
    }

    public void setList(List<LiveShowItemBean> list) {
        this.list = list;
    }
}
