package com.sankuai.waimai.router.demo.lib1.advanced;

import com.sankuai.waimai.router.annotation.RouterService;
import com.tt.lib.advanced.services.LibraryModule;

/**
 * Created by jzj on 2018/4/19.
 */
@RouterService(interfaces = LibraryModule.class)
public class LibraryModule1 extends LibraryModule {

    @Override
    public String getModuleName() {
        return "lib1";
    }
}
