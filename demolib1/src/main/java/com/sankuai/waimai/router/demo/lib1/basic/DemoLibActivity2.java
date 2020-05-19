package com.sankuai.waimai.router.demo.lib1.basic;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sankuai.waimai.router.annotation.RouterUri;
import com.tt.lib.ToastUtils;
import com.tt.lib.app.BaseActivity;
import com.tt.lib.app.DemoConstant;
import com.tt52.demolib1_export.bean.HelloWorldEvent;
import com.tt52.module1_export.event.Module1EventsManager;

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
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
