package com.quwan.tt.router.demo.lib2.basic;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.quwan.tt.router.Router;
import com.quwan.tt.router.annotation.RouterUri;
import com.quwan.tt.router.demo.lib2.service.IpcService;
import com.quwan.tt.router.demo.lib2.R;
import com.tt.lib.ToastUtils;
import com.tt.lib.app.BaseActivity;
import com.tt.lib.app.DemoConstant;
import com.tt52.demolib2_export.Demolib2EventsManager;
import com.tt52.demolib2_export.bean.HelloWorldEvent;

/**
 * Created by jzj on 2018/3/29.
 */
@RouterUri(path = DemoConstant.TEST_LIB2)
public class DemoLibActivity2 extends BaseActivity {

    private TextView recieveipc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demolib2_activity_main);
        Log.e("mainactivity》》","启动服务"+startService(new Intent(DemoLibActivity2.this, IpcService.class)));

        recieveipc = findViewById(R.id.recieveipc);
        recieveipc.setText("收到：");
        Button tolib1 = findViewById(R.id.tolib1);
        tolib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.startUri(DemoLibActivity2.this, DemoConstant.TEST_LIB1);
            }
        });

        Demolib2EventsManager.EVENT1().observe(this, new Observer<HelloWorldEvent>() {
            @Override
            public void onChanged(@Nullable HelloWorldEvent helloWorldEvent) {
                ToastUtils.showToast(DemoLibActivity2.this,helloWorldEvent.name);
            }
        });
    }

}
