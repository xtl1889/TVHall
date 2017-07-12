package com.dwb.ruyou.tvhall.model;

import java.util.List;

/**
 * Created by Slayer on 2017/6/5.
 */

public class TestModel {


    /**
     * ---------测试数据---------
     *
     * result : SUCCESS
     * version : 2.4.1
     * updateMessage : 1.调整部分界面\n2.修复部分bug
     */

    private String result;
    private String version;
    private String updateMessage;

    private boolean isShowDelImg;
    private List<String> list;

    private int viewTag;

    public int getViewTag() {
        return viewTag;
    }

    public void setViewTag(int viewTag) {
        this.viewTag = viewTag;
    }

    public boolean isShowDelImg() {
        return isShowDelImg;
    }

    public void setShowDelImg(boolean showDelImg) {
        isShowDelImg = showDelImg;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUpdateMessage() {
        return updateMessage;
    }

    public void setUpdateMessage(String updateMessage) {
        this.updateMessage = updateMessage;
    }


    class TestModelSecond{
        private int viewTag;
        private String title;

        public int getViewTag() {
            return viewTag;
        }

        public void setViewTag(int viewTag) {
            this.viewTag = viewTag;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
    @Override
    public String toString() {
        return "result="+result+
                ",version="+version+
                ",update="+updateMessage;
    }
}
