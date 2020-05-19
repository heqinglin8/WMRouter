package com.sankuai.waimai.router.demo.lib1.basic;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sankuai.waimai.router.annotation.RouterUri;
import com.sankuai.waimai.router.demo.lib1.R;
import com.tt.lib.ToastUtils;
import com.tt.lib.app.BaseActivity;
import com.tt.lib.app.DemoConstant;
import com.tt.lib.constant.EventConstant;
import com.tt52.demolib1_export.bean.HelloWorldEvent;
import com.tt52.module1_export.event.Module1EventsManager;
import com.tt52.moduleevent.LiveEventBus;

/**
 * Created by jzj on 2018/3/29.
 */
@RouterUri(path = DemoConstant.TEST_LIB1)
public class DemoLibActivity1 extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView sendipc = findViewById(R.id.sendipc);
        sendipc.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                sendBroadcastMsg(v);
            }
        });

        Module1EventsManager.EVENT1().observe(this, new Observer<HelloWorldEvent>() {
            @Override
            public void onChanged(@Nullable HelloWorldEvent helloWorldEvent) {
                ToastUtils.showToast(DemoLibActivity1.this,helloWorldEvent.name);
            }
        });
    }

    public void sendBroadcastMsg(View v) {
        Module1EventsManager.EVENT1().postAcrossApp(new HelloWorldEvent("heqinglin",null));
    }
}
