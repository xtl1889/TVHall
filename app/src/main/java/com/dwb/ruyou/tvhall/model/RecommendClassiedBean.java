package com.dwb.ruyou.tvhall.model;

/**
 * Created by Slayer on 2017/7/11.
 * 主页推荐 的bean
 */

public class RecommendClassiedBean {
    /**
     * id : 1
     * name : 我的世界
     * img : http://lion.ufile.ucloud.com.cn/cms/game/default/4JRBMXWYwzWn4n3t.png
     * recommendRate : 0
     */

    private int id;
    private String name;
    private String img;
    private int recommendRate;
    private String tag;//首页 更多常用标记

    public RecommendClassiedBean() {
    }
    public RecommendClassiedBean(String tag) {
        this.tag = tag;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getRecommendRate() {
        return recommendRate;
    }

    public void setRecommendRate(int recommendRate) {
        this.recommendRate = recommendRate;
    }
}
