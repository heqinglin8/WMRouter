package com.sankuai.waimai.router.demo.lib1.basic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jeremyliao.liveeventbus.LiveEventBus;
import com.sankuai.waimai.router.annotation.RouterUri;
import com.sankuai.waimai.router.demo.lib1.R;
import com.tt.lib.app.BaseActivity;
import com.tt.lib.app.DemoConstant;
import com.tt.lib.constant.EventConstant;

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
    }

    public void sendBroadcastMsg(View v) {
        LiveEventBus.get(EventConstant.TEST_BRC_KEY).broadcast("msg from liveeventbus");
    }
}
