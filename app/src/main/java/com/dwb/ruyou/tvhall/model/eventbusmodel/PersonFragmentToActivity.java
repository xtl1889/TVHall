package com.dwb.ruyou.tvhall.model.eventbusmodel;

/**
 * Created by Slayer on 2017/6/27.
 */

public class PersonFragmentToActivity {

    private boolean isReques;
    private int fragmentTag;

    public PersonFragmentToActivity(boolean isReques, int fragmentTag) {
        this.isReques = isReques;
        this.fragmentTag = fragmentTag;
    }

    public boolean isReques() {
        return isReques;
    }

    public void setReques(boolean reques) {
        isReques = reques;
    }

    public int getFragmentTag() {
        return fragmentTag;
    }

    public void setFragmentTag(int fragmentTag) {
        this.fragmentTag = fragmentTag;
    }

    @Override
    public String toString() {
        return "isReques:"+isReques()+
                ",fragmentTag:"+fragmentTag;
    }
}
