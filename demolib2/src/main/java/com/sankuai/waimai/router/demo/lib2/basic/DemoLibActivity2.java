package com.sankuai.waimai.router.demo.lib2.basic;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sankuai.waimai.router.demo.lib2.service.IpcService;
import com.sankuai.waimai.router.annotation.RouterUri;
import com.sankuai.waimai.router.demo.lib2.R;
import com.tt.lib.app.BaseActivity;
import com.tt.lib.app.DemoConstant;

/**
 * Created by jzj on 2018/3/29.
 */
@RouterUri(path = DemoConstant.TEST_LIB2)
public class DemoLibActivity2 extends BaseActivity {

    private TextView recieveipc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recieveipc = findViewById(R.id.recieveipc);
        recieveipc.setText("收到：");
        Intent intent = new Intent(DemoLibActivity2.this, IpcService.class);
        Log.e("mainactivity》》","启动服务"+startService(intent));
    }

}
