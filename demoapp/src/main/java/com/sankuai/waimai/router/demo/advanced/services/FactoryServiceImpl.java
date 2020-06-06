package com.sankuai.waimai.router.demo.advanced.services;

import android.content.Context;

import com.sankuai.waimai.router.annotation.RouterProvider;
import com.sankuai.waimai.router.annotation.RouterService;
import com.tt.lib.advanced.services.IFactoryService;

@RouterService(interfaces = IFactoryService.class, key = "/factory")
public class FactoryServiceImpl implements IFactoryService {

    private final String mName;

    @RouterProvider
    public static FactoryServiceImpl provideService() {
        return new FactoryServiceImpl("CreateByProvider");
    }

    public FactoryServiceImpl() {
        mName = "CreateWithEmptyArgs";
    }

    public FactoryServiceImpl(Context context) {
        mName = "CreateWithContext";
    }

    public FactoryServiceImpl(String name) {
        mName = name;
    }

    @Override
    public String name() {
        return mName;
    }
}
