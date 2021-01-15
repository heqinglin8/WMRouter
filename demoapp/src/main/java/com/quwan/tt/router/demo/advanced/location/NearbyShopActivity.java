package com.quwan.tt.router.demo.advanced.location;

import com.quwan.tt.router.annotation.RouterUri;
import com.tt.lib.app.BaseActivity;
import com.tt.lib.app.DemoConstant;

/**
 * 附近商家，需要先定位
 *
 * Created by jzj on 2018/3/26.
 */
@RouterUri(path = DemoConstant.NEARBY_SHOP_WITH_LOCATION_INTERCEPTOR,
        interceptors = LocationInterceptor.class)
public class NearbyShopActivity extends BaseActivity {

}
