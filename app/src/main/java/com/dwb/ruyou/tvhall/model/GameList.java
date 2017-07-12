package com.dwb.ruyou.tvhall.model;

import java.util.List;

/**
 * Created by Slayer on 2017/7/5.
 */

public class GameList {

    /**
     * result : SUCCESS
     * tvGameList : [{"id":1,"gameName":"梦中旅人","gameUuid":"mengzhonglvren","cpId":"1","cpUuid":"bingyu","appKey":"dream","appSeceret":"b1468f99af86feca328321295d07c7a1","createTime":null,"updateTime":1494405995000,"isDelete":"0","joystickVersion":"1.0.8","isRecommandTvMarket":1,"star":0,"apkSize":35.56,"onlineTime":1479197245000,"icon":"/icon/dream-icon.png","gameType":"音乐跑酷","downloadNumber":1,"profitRatio":50,"status":null,"gameVersion":"1.3.0","apkName":null,"apkAddr":null,"notifyVersion":"1","payChannelAccount":8,"payType":"empty","isDirectProfit":0,"packageName":"com.tai.jump","isOnlineGame":0,"dwbLogoutKill":0,"dwbConnectCount":1,"dwbDoubleBack":1,"iosJoystickVersion":"1.0.1","reviseVersion":1,"mobileDwbDoubleBack":1,"dwbPayCallbackOnui":0,"recommendRate":0,"dwbLoginCallbackOnui":0,"dwbRemoteControl":0,"dwbRemoteMoveValue":20,"dwbTvPhoneGameQrShowTime":20,"gameBrief":"游戏简介游戏简介游戏简介游戏简介游戏简介游戏简介游戏简介游戏简介游戏简介游戏简介游戏简介游戏简介游戏简介游戏简介游戏简介","pictures":null}]
     */

    private String result;
    private List<GameItemBean> tvGameList;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<GameItemBean> getTvGameList() {
        return tvGameList;
    }

    public void setTvGameList(List<GameItemBean> tvGameList) {
        this.tvGameList = tvGameList;
    }
}
