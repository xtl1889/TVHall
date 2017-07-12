package com.dwb.ruyou.tvhall.model;

/**
 * Created by Slayer on 2017/6/6.
 */

public class TestModel_post {

    /**
     * result : SUCCESS
     * sdkVersion : 1.3
     * packageAddress : http://user-update.ru-you.com/updateGame/t_test/梦中旅人-联网版TV.apk
     */

    private String result;
    private String sdkVersion;
    private String packageAddress;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public String getPackageAddress() {
        return packageAddress;
    }

    public void setPackageAddress(String packageAddress) {
        this.packageAddress = packageAddress;
    }

    @Override
    public String toString() {
        return "result="+result+
                ",sdkVersion="+sdkVersion+
                ",packageAddress="+packageAddress;
    }
}
