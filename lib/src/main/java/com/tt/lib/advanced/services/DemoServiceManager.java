package com.tt.lib.advanced.services;

import com.quwan.tt.router.Router;
import com.tt.lib.app.DemoConstant;

/**
 * Created by jzj on 2018/4/19.
 */

public class DemoServiceManager {

    public static IAccountService getAccountService() {
        return Router.getService(IAccountService.class, DemoConstant.SINGLETON);
    }

    public static ILocationService getLocationService() {
        return Router.getService(ILocationService.class, DemoConstant.SINGLETON);
    }
}
