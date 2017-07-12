package com.dwb.ruyou.tvhall.model;

import java.util.List;

/**
 * Created by Slayer on 2017/7/11.
 */

public class RecommendModel {

    /**
     * result : SUCCESS
     * livingShowRoomList : [{"id":7,"livingShowPlatform":"狮吼","livingShowPlatformUuid":"10146","userName":"小逸逸","userAvatar":"http://lion.ufile.ucloud.com.cn/avatar/244226/4Nz5Z1y1JqrhB16Q.jpg?iopcmd=thumbnail&width=400&height=400&type=8","livingShowRoomName":"帮榜单上荣耀了","audienceNumber":55143,"isBroadcasting":1,"livingShowTypeId":"1","livingShowSubTypeId":null,"recommendRate":55143,"img":"http://f8055061lvb1253151404screenshot-1252813850.file.myqcloud.com/shihou/5659_10146_prod-320.jpg?t=1499678069&tt=1499679047"},{"id":10,"livingShowPlatform":"狮吼","livingShowPlatformUuid":"219685","userName":"鹿哥哥","userAvatar":"http://lion.ufile.ucloud.com.cn/avatar/1028599/4Nurdsl8VkqFkJex.jpg?iopcmd=thumbnail&width=400&height=400&type=8","livingShowRoomName":"一起来飞车啊","audienceNumber":52684,"isBroadcasting":1,"livingShowTypeId":"46","livingShowSubTypeId":null,"recommendRate":52684,"img":"http://f8055061lvb1253151404screenshot-1252813850.file.myqcloud.com/shihou/5659_219685_prod-320.jpg?t=1499678057&tt=1499679047"},{"id":8,"livingShowPlatform":"狮吼","livingShowPlatformUuid":"10013","userName":"SC丶安然","userAvatar":"http://lion.ufile.ucloud.com.cn/avatar/246621/4NbVKDHX8Ow3Mi72.jpg?iopcmd=thumbnail&width=400&height=400&type=8","livingShowRoomName":"带徒弟们5黑","audienceNumber":50477,"isBroadcasting":1,"livingShowTypeId":"1","livingShowSubTypeId":null,"recommendRate":50477,"img":"http://f8055061lvb1253151404screenshot-1252813850.file.myqcloud.com/shihou/5659_10013_prod-320.jpg?t=1499677838&tt=1499679047"},{"id":9,"livingShowPlatform":"狮吼","livingShowPlatformUuid":"140709","userName":"史上最酷的尾巴","userAvatar":"http://lion.ufile.ucloud.com.cn/avatar/841541/4MhCNDljLunxPiHT.jpg?iopcmd=thumbnail&width=400&height=400&type=8","livingShowRoomName":"打单子安卓微信区","audienceNumber":50081,"isBroadcasting":1,"livingShowTypeId":"2","livingShowSubTypeId":null,"recommendRate":50081,"img":"http://f8055061lvb1253151404screenshot-1252813850.file.myqcloud.com/shihou/5659_140709_prod-320.jpg?t=1499677837&tt=1499679047"},{"id":11,"livingShowPlatform":"狮吼","livingShowPlatformUuid":"126354","userName":"CFM夏季职业邀请赛","userAvatar":"http://lion.ufile.ucloud.com.cn/avatar/764766/4ODdsRUKHiXHQ8D6.jpg?iopcmd=thumbnail&width=400&height=400&type=8","livingShowRoomName":"VML-CFM夏季邀请赛","audienceNumber":48442,"isBroadcasting":1,"livingShowTypeId":"2","livingShowSubTypeId":null,"recommendRate":48442,"img":"http://f8055061lvb1253151404screenshot-1252813850.file.myqcloud.com/shihou/5659_126354_prod-320.jpg?t=1499677838&tt=1499679047"},{"id":12,"livingShowPlatform":"狮吼","livingShowPlatformUuid":"62598","userName":"๑慧子姐姐๑","userAvatar":"http://lion.ufile.ucloud.com.cn/avatar/532936/4No8N5pQ6mDPYEar.jpg?iopcmd=thumbnail&width=400&height=400&type=8","livingShowRoomName":"点点关注，谢谢","audienceNumber":47038,"isBroadcasting":1,"livingShowTypeId":"2","livingShowSubTypeId":null,"recommendRate":47038,"img":"http://f8055061lvb1253151404screenshot-1252813850.file.myqcloud.com/shihou/5659_62598_prod-320.jpg?t=1499678069&tt=1499679047"},{"id":13,"livingShowPlatform":"狮吼","livingShowPlatformUuid":"11666","userName":"骚家军丶骚贵","userAvatar":"http://lion.ufile.ucloud.com.cn/avatar/252443/4LvM3Poi1GkjrWqR.jpg?iopcmd=thumbnail&width=400&height=400&type=8","livingShowRoomName":"小姐姐们来聊天拉","audienceNumber":44987,"isBroadcasting":1,"livingShowTypeId":"1","livingShowSubTypeId":null,"recommendRate":44987,"img":"http://f8055061lvb1253151404screenshot-1252813850.file.myqcloud.com/shihou/5659_11666_prod-320.jpg?t=1499678452&tt=1499679047"},{"id":14,"livingShowPlatform":"狮吼","livingShowPlatformUuid":"94579","userName":"雷刃电竞_傲尘","userAvatar":"http://lion.ufile.ucloud.com.cn/avatar/651407/4O8UNngqdcrxK3Cv.jpg?iopcmd=thumbnail&width=400&height=400&type=8","livingShowRoomName":"先生里面请，男宾三位！","audienceNumber":40390,"isBroadcasting":1,"livingShowTypeId":"1","livingShowSubTypeId":null,"recommendRate":40390,"img":"http://f8055061lvb1253151404screenshot-1252813850.file.myqcloud.com/shihou/5659_94579_prod-320.jpg?t=1499678286&tt=1499679047"}]
     * livingShowGameList : [{"id":1,"name":"我的世界","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4JRBMXWYwzWn4n3t.png","recommendRate":0},{"id":2,"name":"择天记","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4O6hFVOJbjTaZg5R.png","recommendRate":0},{"id":3,"name":"狮吼星秀","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4Nt7eIkxra8gMWiM.png","recommendRate":0},{"id":4,"name":"欢乐球吃球","img":"http://lion.ufile.ucloud.com.cn/cms/game/default/4O4j2bAZxMP55Xt0.png","recommendRate":0}]
     * cpGameList : [{"id":1,"gameName":"梦中旅人","gameUuid":"mengzhonglvren","cpId":"1","cpUuid":"bingyu","appKey":"dream","appSeceret":"b1468f99af86feca328321295d07c7a1","createTime":null,"updateTime":1494405995000,"isDelete":"0","joystickVersion":"1.0.8","isRecommandTvMarket":1,"star":0,"apkSize":35.56,"onlineTime":1479197245000,"icon":"/icon/dream-icon.png","gameType":"音乐跑酷","downloadNumber":1,"profitRatio":50,"status":null,"gameVersion":"1.3.0","apkName":null,"apkAddr":null,"notifyVersion":"1","payChannelAccount":8,"payType":"empty","isDirectProfit":0,"packageName":"com.tai.jump","isOnlineGame":0,"dwbLogoutKill":0,"dwbConnectCount":1,"dwbDoubleBack":1,"iosJoystickVersion":"1.0.1","reviseVersion":1,"mobileDwbDoubleBack":1,"dwbPayCallbackOnui":0,"recommendRate":0,"dwbLoginCallbackOnui":0,"dwbRemoteControl":0,"dwbRemoteMoveValue":20,"dwbTvPhoneGameQrShowTime":20,"gameBrief":"游戏简介游戏简介游戏简介游戏简介游戏简介游戏简介游戏简介游戏简介游戏简介游戏简介游戏简介游戏简介游戏简介游戏简介游戏简介","pictures":null},{"id":2,"gameName":"NBA英雄","gameUuid":"nbayingxiong","cpId":"2","cpUuid":"dashi","appKey":"big_nba","appSeceret":"2eb75451eeac8fa8f0666a3cadf4bdb6","createTime":null,"updateTime":null,"isDelete":"0","joystickVersion":"1.0.0","isRecommandTvMarket":null,"star":0,"apkSize":0,"onlineTime":1479197248000,"icon":null,"gameType":"卡牌","downloadNumber":0,"profitRatio":50,"status":null,"gameVersion":null,"apkName":null,"apkAddr":null,"notifyVersion":"2","payChannelAccount":0,"payType":null,"isDirectProfit":0,"packageName":null,"isOnlineGame":1,"dwbLogoutKill":0,"dwbConnectCount":1,"dwbDoubleBack":1,"iosJoystickVersion":"1.0.0","reviseVersion":1,"mobileDwbDoubleBack":1,"dwbPayCallbackOnui":0,"recommendRate":0,"dwbLoginCallbackOnui":0,"dwbRemoteControl":0,"dwbRemoteMoveValue":20,"dwbTvPhoneGameQrShowTime":20,"gameBrief":null,"pictures":null},{"id":4,"gameName":"电玩宝","gameUuid":"dwb","cpId":"4","cpUuid":"dwb","appKey":"dwb_demo","appSeceret":"4a97119df97c36359b18c686a1b43eea","createTime":null,"updateTime":1489648103000,"isDelete":"0","joystickVersion":"1.0.4","isRecommandTvMarket":null,"star":0,"apkSize":9.23,"onlineTime":1479197251000,"icon":"/icon/dwb_demo-icon.png","gameType":null,"downloadNumber":0,"profitRatio":50,"status":null,"gameVersion":null,"apkName":null,"apkAddr":null,"notifyVersion":"2","payChannelAccount":0,"payType":"dwb","isDirectProfit":0,"packageName":"org.cocos2dx.Cocos2dxSdkDemo","isOnlineGame":0,"dwbLogoutKill":0,"dwbConnectCount":1,"dwbDoubleBack":1,"iosJoystickVersion":"1.0.3","reviseVersion":1,"mobileDwbDoubleBack":1,"dwbPayCallbackOnui":0,"recommendRate":0,"dwbLoginCallbackOnui":0,"dwbRemoteControl":0,"dwbRemoteMoveValue":20,"dwbTvPhoneGameQrShowTime":20,"gameBrief":null,"pictures":null},{"id":9,"gameName":"口袋斗地主","gameUuid":"kdddz","cpId":"8","cpUuid":"kdddz","appKey":"pocket_landlords","appSeceret":"2beb95e7aca29a926a581a82770c2c3e","createTime":null,"updateTime":null,"isDelete":"0","joystickVersion":"1.1.3","isRecommandTvMarket":null,"star":0,"apkSize":12.5,"onlineTime":1479197261000,"icon":"/icon/pocket_landlords-icon.png","gameType":"休闲游戏","downloadNumber":0,"profitRatio":50,"status":null,"gameVersion":null,"apkName":null,"apkAddr":null,"notifyVersion":"1","payChannelAccount":0,"payType":null,"isDirectProfit":0,"packageName":"com.tencent.tmgp.ddz","isOnlineGame":1,"dwbLogoutKill":0,"dwbConnectCount":1,"dwbDoubleBack":1,"iosJoystickVersion":"1.0.0","reviseVersion":1,"mobileDwbDoubleBack":1,"dwbPayCallbackOnui":0,"recommendRate":0,"dwbLoginCallbackOnui":0,"dwbRemoteControl":0,"dwbRemoteMoveValue":20,"dwbTvPhoneGameQrShowTime":20,"gameBrief":null,"pictures":null},{"id":13,"gameName":"我朝有马","gameUuid":"wochaoyouma","cpId":"11","cpUuid":"wochaoyouma","appKey":"wcym","appSeceret":"3beb95e7aca29a926a581a82770c2c3e","createTime":null,"updateTime":1493972024000,"isDelete":"0","joystickVersion":"1.1.7","isRecommandTvMarket":null,"star":0,"apkSize":248.14,"onlineTime":1479197269000,"icon":"/icon/wcym-icon.png","gameType":"卡牌","downloadNumber":0,"profitRatio":50,"status":null,"gameVersion":null,"apkName":null,"apkAddr":null,"notifyVersion":"2","payChannelAccount":0,"payType":null,"isDirectProfit":0,"packageName":"com.Youzong.Youma","isOnlineGame":1,"dwbLogoutKill":0,"dwbConnectCount":1,"dwbDoubleBack":1,"iosJoystickVersion":"1.0.0","reviseVersion":1,"mobileDwbDoubleBack":0,"dwbPayCallbackOnui":0,"recommendRate":0,"dwbLoginCallbackOnui":0,"dwbRemoteControl":0,"dwbRemoteMoveValue":20,"dwbTvPhoneGameQrShowTime":20,"gameBrief":null,"pictures":null}]
     */

    private String result;
    private List<LiveShowItemBean> livingShowRoomList;
    private List<RecommendClassiedBean> livingShowGameList;
    private List<GameItemBean> cpGameList;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
