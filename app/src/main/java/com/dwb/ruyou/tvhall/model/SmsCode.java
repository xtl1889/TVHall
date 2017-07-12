package com.dwb.ruyou.tvhall.model;

/**
 * Created by Slayer on 2017/7/3.
 */

public class SmsCode {

    /**
     * result : Fail
     * msg : 验签错误
     * errorCode : 3
     */

    private String result;
    private String msg;
    private String errorCode;

    @Override
    public String toString() {
        return "result="+result+
                ",msg="+msg+
                ",errorCode="+errorCode;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
}
