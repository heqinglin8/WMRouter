package com.sankuai.waimai.router.demo.lib2.basic;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jeremyliao.liveeventbus.LiveEventBus;
import com.sankuai.waimai.router.annotation.RouterUri;
import com.sankuai.waimai.router.demo.lib2.R;
import com.tt.lib.app.BaseActivity;
import com.tt.lib.app.DemoConstant;
import com.tt.lib.constant.EventConstant;

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

        registerRecieve();
    }

    private void registerRecieve(){
        LiveEventBus.get(EventConstant.TEST_BRC_KEY, String.class).observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        Toast.makeText(DemoLibActivity2.this, "receive massage: " + s, Toast.LENGTH_SHORT).show();
                        recieveipc.setText(s);
                    }
                });
    }
}
