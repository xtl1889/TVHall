package com.dwb.ruyou.tvhall.model;

import java.util.List;

/**
 * Created by Slayer on 2017/7/7.
 */

public class LiveShowList {


    /**
     * result : SUCCESS
     * list : [{"id":5,"livingShowPlatform":"狮吼","livingShowPlatformUuid":"a1","userName":"a2","userAvatar":"/asdasdf","livingShowRoomName":"123","audienceNumber":0,"isBroadcasting":1,"livingShowTypeId":"1","livingShowSubTypeId":"1","recommendRate":5,"img":"/asd132"},{"id":6,"livingShowPlatform":null,"livingShowPlatformUuid":null,"userName":null,"userAvatar":null,"livingShowRoomName":null,"audienceNumber":0,"isBroadcasting":1,"livingShowTypeId":null,"livingShowSubTypeId":null,"recommendRate":4,"img":null},{"id":4,"livingShowPlatform":null,"livingShowPlatformUuid":null,"userName":null,"userAvatar":null,"livingShowRoomName":null,"audienceNumber":0,"isBroadcasting":1,"livingShowTypeId":null,"livingShowSubTypeId":null,"recommendRate":3,"img":null},{"id":3,"livingShowPlatform":null,"livingShowPlatformUuid":null,"userName":"123","userAvatar":null,"livingShowRoomName":null,"audienceNumber":0,"isBroadcasting":1,"livingShowTypeId":null,"livingShowSubTypeId":null,"recommendRate":2,"img":null},{"id":2,"livingShowPlatform":null,"livingShowPlatformUuid":null,"userName":null,"userAvatar":null,"livingShowRoomName":null,"audienceNumber":0,"isBroadcasting":1,"livingShowTypeId":null,"livingShowSubTypeId":null,"recommendRate":1,"img":null},{"id":1,"livingShowPlatform":"狮吼","livingShowPlatformUuid":"a1","userName":"a2","userAvatar":"/asd","livingShowRoomName":"123","audienceNumber":0,"isBroadcasting":1,"livingShowTypeId":"1","livingShowSubTypeId":"1","recommendRate":0,"img":"/asd"}]
     */

    private String result;
    private List<LiveShowItemBean> list;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<LiveShowItemBean> getList() {
        return list;
    }

    public void setList(List<LiveShowItemBean> list) {
        this.list = list;
    }

}
