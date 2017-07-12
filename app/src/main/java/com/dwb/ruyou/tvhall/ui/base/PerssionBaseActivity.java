package com.dwb.ruyou.tvhall.ui.base;

import android.Manifest;
import android.os.Bundle;

import pub.devrel.easypermissions.EasyPermissions;

public abstract class PerssionBaseActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks{

    public String[] permissionPerms={Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private static final int CODE_REQUEST_PERMISSION = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private void checkPermisson(){
        if (EasyPermissions.hasPermissions(this,permissionPerms)){

        }else {
            EasyPermissions.requestPermissions(this, "需要访问SD的权限!", CODE_REQUEST_PERMISSION, permissionPerms);
        }
    }
}
