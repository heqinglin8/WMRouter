package com.sankuai.waimai.router.demo.basic;

import com.sankuai.waimai.router.annotation.RouterUri;
import com.tt.lib.app.BaseActivity;
import com.tt.lib.app.DemoConstant;

/**
 * Created by jzj on 2018/3/26.
 */
@RouterUri(
        scheme = DemoConstant.DEMO_SCHEME,
        host = DemoConstant.DEMO_HOST,
        path = DemoConstant.NOT_EXPORTED_PATH
)
public class NotExportedActivity extends BaseActivity {

}
