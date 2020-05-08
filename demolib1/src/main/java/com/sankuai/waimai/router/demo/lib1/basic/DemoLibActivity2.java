package com.sankuai.waimai.router.demo.lib1.basic;

import com.sankuai.waimai.router.annotation.RouterUri;
import com.tt.lib.app.BaseActivity;
import com.tt.lib.app.DemoConstant;

/**
 * Created by jzj on 2018/3/29.
 */
@RouterUri(
        scheme = DemoConstant.LIB1_SCHEME,
        host = DemoConstant.LIB1_HOST,
        path = DemoConstant.EXPORTED_PATH,
        exported = true
)
public class DemoLibActivity2 extends BaseActivity {

}
