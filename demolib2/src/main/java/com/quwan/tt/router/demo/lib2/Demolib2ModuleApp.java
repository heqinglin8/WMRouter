package com.quwan.tt.router.demo.lib2;

import com.tt.lib.app.BaseAppModuleApp;
import com.tt52.moduleevent.LiveEventBus;

/**
 * @PackageName com.quwan.tt.router.demo.lib2
 * @ClassName Demolib2ModuleApp
 * @Author heqinglin
 * @Date 2020/5/19 下午6:15
 * @Description TODO
 */
public class Demolib2ModuleApp extends BaseAppModuleApp {

    @Override
    public void onCreate() {
        super.onCreate();
        LiveEventBus.config()
                .lifecycleObserverAlwaysActive(true);
    }
}
