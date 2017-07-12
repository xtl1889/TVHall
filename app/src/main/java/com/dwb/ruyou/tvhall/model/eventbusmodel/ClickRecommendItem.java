package com.dwb.ruyou.tvhall.model.eventbusmodel;

/**
 * Created by Slayer on 2017/7/12.
 */

public class ClickRecommendItem {
    private String tag;//数据来源
    private int id;

    public ClickRecommendItem(String tag, int id) {
        this.tag = tag;
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
