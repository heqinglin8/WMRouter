package com.quwan.tt.router.demo.advanced.services;

import android.os.Handler;

import com.quwan.tt.router.annotation.RouterService;
import com.tt.lib.app.DemoConstant;
import com.tt.lib.advanced.services.ILocationService;

/**
 * Created by jzj on 2018/3/26.
 */
@RouterService(interfaces = ILocationService.class, key = DemoConstant.SINGLETON, singleton = true)
public class FakeLocationService implements ILocationService {

    private final Handler mHandler = new Handler();

    @Override
    public boolean hasLocation() {
        return false;
    }

    @Override
    public void startLocation(final LocationListener listener) {
        if (listener != null) {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    listener.onSuccess();
                }
            }, 800);
        }
    }
}
