package com.dwb.ruyou.tvhall.model;

/**
 * Created by Slayer on 2017/7/3.
 */

public class UserLoginInfo {

    /**
     * result : SUCCESS
     * uuid : 1488423940445fdc
     * nickName : test
     * accessToken : gzrIBqMjgpCSEgexIo
     * isAttended : false
     * msg 登录失败提示
     * errorCode 登录失败code
     */

    private String result;
    private String uuid;
    private String nickName;
    private String accessToken;
    private String isAttended;

    private String msg;
    private String errorCode;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getIsAttended() {
        return isAttended;
    }

    public void setIsAttended(String isAttended) {
        this.isAttended = isAttended;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "result="+result+
                ",uuid="+uuid+
                ",nickName="+nickName+
                ",accessToken="+accessToken+
                ",isAttended="+isAttended+
                ",msg="+msg+
                ",errorCode"+errorCode;
    }
}
