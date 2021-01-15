package com.quwan.tt.router.demo.advanced.services;

import android.content.Context;
import android.content.pm.PackageManager;

import com.quwan.tt.router.annotation.RouterService;
import com.quwan.tt.router.demo.app.DemoApplication;
import com.quwan.tt.router.method.Func0;
import com.tt.lib.app.DemoConstant;

/**
 * Created by jzj on 2018/4/19.
 */
@RouterService(interfaces = Func0.class, key = DemoConstant.GET_VERSION_CODE, singleton = true)
public class GetVersionCodeMethod implements Func0<Integer> {

    @Override
    public Integer call() {
        try {
            Context context = DemoApplication.getContext();
            return context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0)
                    .versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return -1;
        }
    }
}
