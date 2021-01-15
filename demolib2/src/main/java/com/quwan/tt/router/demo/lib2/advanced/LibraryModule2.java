package com.quwan.tt.router.demo.lib2.advanced;

import com.quwan.tt.router.annotation.RouterService;
import com.tt.lib.advanced.services.LibraryModule;

/**
 * Created by jzj on 2018/4/19.
 */
@RouterService(interfaces = LibraryModule.class)
public class LibraryModule2 extends LibraryModule {

    @Override
    public String getModuleName() {
        return "lib2";
    }
}
