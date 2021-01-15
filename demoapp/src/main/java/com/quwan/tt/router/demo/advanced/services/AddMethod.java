package com.quwan.tt.router.demo.advanced.services;

import com.quwan.tt.router.annotation.RouterService;
import com.quwan.tt.router.method.Func2;
import com.tt.lib.app.DemoConstant;

/**
 * Created by jzj on 2018/4/16.
 */
@RouterService(interfaces = Func2.class, key = DemoConstant.ADD_METHOD, singleton = true)
public class AddMethod implements Func2<Integer, Integer, Integer> {

    @Override
    public Integer call(Integer a, Integer b) {
        return a + b;
    }
}
