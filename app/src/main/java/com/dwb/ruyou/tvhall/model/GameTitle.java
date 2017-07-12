package com.dwb.ruyou.tvhall.model;

import java.util.List;

/**
 * Created by Slayer on 2017/7/5.
 */

public class GameTitle {

    /**
     * result : SUCCESS
     * gameTypeList : ["音乐跑酷","卡牌","休闲游戏","ARPG","MMORPG","策略","休闲竞技","格斗","体育竞技","网游","塔防","街机格斗","MMDRPG","音乐酷跑","动作冒险","声控酷跑","竞技"]
     */

    private String result;
    private List<String> gameTypeList;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<String> getGameTypeList() {
        return gameTypeList;
    }

    public void setGameTypeList(List<String> gameTypeList) {
        this.gameTypeList = gameTypeList;
    }
}
