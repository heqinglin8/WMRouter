package com.sankuai.waimai.router.demo.lib1.basic;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sankuai.waimai.router.annotation.RouterUri;
import com.sankuai.waimai.router.demo.lib1.R;
import com.tt.lib.ToastUtils;
import com.tt.lib.app.BaseActivity;
import com.tt.lib.app.DemoConstant;
import com.tt52.demolib2_export.Demolib2EventsManager;
import com.tt52.demolib2_export.bean.HelloWorldEvent;

/**
 * Created by jzj on 2018/3/29.
 */
@RouterUri(path = DemoConstant.TEST_LIB1)
public class DemoLibActivity1 extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView send = findViewById(R.id.sendipc);
        TextView sendipc = findViewById(R.id.sendipc);
        send.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Demolib2EventsManager.EVENT1().postAcrossApp(new HelloWorldEvent("heqinglin",null));
            }
        });

        sendipc.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                sendBroadcastMsg(v);
            }
        });

    }

    public void sendBroadcastMsg(View v) {
        Demolib2EventsManager.EVENT3().postAcrossApp("Demo1发来的");
    }
}
