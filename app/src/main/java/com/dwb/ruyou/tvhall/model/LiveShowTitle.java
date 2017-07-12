package com.dwb.ruyou.tvhall.model;

import java.util.List;

/**
 * Created by Slayer on 2017/7/11.
 */

public class LiveShowTitle {

    /**
     * result : SUCCESS
     * list : [{"id":1,"name":"我的世界","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4JRBMXWYwzWn4n3t.png","recommendRate":0},{"id":2,"name":"择天记","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4O6hFVOJbjTaZg5R.png","recommendRate":0},{"id":3,"name":"狮吼星秀","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4Nt7eIkxra8gMWiM.png","recommendRate":0},{"id":4,"name":"欢乐球吃球","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4O4j2bAZxMP55Xt0.png","recommendRate":0},{"id":5,"name":"天龙八部手游","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4ODU41nGrXNrZKUi.png","recommendRate":0},{"id":6,"name":"王者荣耀","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4LA2BXUamX7oDNEW.jpg","recommendRate":0},{"id":7,"name":"穿越火线：枪战王者","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4M70wniVloeizr7g.jpg","recommendRate":0},{"id":8,"name":"球球大作战","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4LA3KgZyRTQgCbAP.jpg","recommendRate":0},{"id":9,"name":"单机手游","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4LAiBQRySYZdfk6s.jpg","recommendRate":0},{"id":10,"name":"部落冲突","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4LA2MxEDUeP8o9iD.jpg","recommendRate":0},{"id":11,"name":"火影忍者","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4LA2Nq7aw9TlS6Sl.png","recommendRate":0},{"id":12,"name":"综合手游","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4LAiC21H8c0ZP1Mz.jpg","recommendRate":0},{"id":13,"name":"贪吃蛇大作战","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4LA2RDYAFTIBfHSs.jpg","recommendRate":0},{"id":14,"name":"时空召唤","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4LAiGKP8nNX9K51k.jpg","recommendRate":0},{"id":15,"name":"大杂烩","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4KFStczGeONDZnTO.jpg","recommendRate":0},{"id":16,"name":"天天酷跑","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4LOHtdosk2BxkdiF.jpg","recommendRate":0},{"id":17,"name":"三国杀","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4LOHwyWmOsjof5On.jpg","recommendRate":0},{"id":18,"name":"一起来飞车","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4LwVy8LSUdYSEtoa.jpg","recommendRate":0},{"id":19,"name":"狼人杀","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4MomwcQfEIcICszV.png","recommendRate":0},{"id":20,"name":"迷你世界","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4N1QocUhmex6Od64.png","recommendRate":0},{"id":21,"name":"魂斗罗：归来","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4NlN4KKH6X1VreL6.jpg","recommendRate":0},{"id":22,"name":"英雄杀","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4Nm70thcOZ2i0lfz.png","recommendRate":0},{"id":23,"name":"英雄战歌","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4Nu0nr89AUvwYTlF.png","recommendRate":0},{"id":24,"name":"魔法门之英雄无敌：战争纪元","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4NykfNJdYRXcmeEt.jpg","recommendRate":0},{"id":25,"name":"射雕英雄传手游","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4OEUCfYyuda4x2BL.png","recommendRate":0},{"id":26,"name":"QQ飞车手游","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4OFKRlaVIco6ucKQ.jpg","recommendRate":0}]
     */

    private String result;
    private List<ListBean> list;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
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
}
