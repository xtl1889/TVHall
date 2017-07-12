package com.dwb.ruyou.tvhall.model.eventbusmodel;

/**
 * Created by Slayer on 2017/6/27.
 */

public class PersonLookedAdapterToFragment {
    private boolean isReques;
    private int position;

    public PersonLookedAdapterToFragment(boolean isReques, int position) {
        this.isReques = isReques;
        this.position = position;
    }

    public boolean isReques() {
        return isReques;
    }

    public void setReques(boolean reques) {
        isReques = reques;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
