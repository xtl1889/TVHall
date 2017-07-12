package com.dwb.ruyou.tvhall.model.eventbusmodel;

/**
 * Created by Slayer on 2017/6/21.
 * 二级级页面 标题获取焦点
 *
 * titleTag 恢复焦点的标记
 * 二级页面下的item按向上键时： 1 主页直播页 2 主页游戏  3、分类详情页
 */

public class MainToTabRequesfous {
    private boolean isReques;
    private String titleTag;


    public MainToTabRequesfous(boolean isReques, String titleTag) {
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
