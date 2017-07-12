package com.dwb.ruyou.tvhall.model.eventbusmodel;

/**
 * Created by Slayer on 2017/6/21.
 * 二级页面传递数据到一级页面  恢复标题获取焦点
 */

public class TabToMainRequesfous {
    private boolean isReques;
    private String titleTag;


    public TabToMainRequesfous(boolean isReques, String titleTag) {
        this.isReques = isReques;
        this.titleTag = titleTag;
    }

    public boolean isReques() {
        return isReques;
    }

    public void setReques(boolean reques) {
        isReques = reques;
    }

    public String getTitleTag() {
        return titleTag;
    }

    public void setTitleTag(String titleTag) {
        this.titleTag = titleTag;
    }

    @Override
    public String toString() {
        return "isRequse:"+isReques()+
                ",titleTag:"+titleTag;
    }
}
