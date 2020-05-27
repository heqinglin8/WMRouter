package com.tt52.usermodlue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.sankuai.waimai.router.annotation.RouterUri;
import com.tt.lib.ToastUtils;
import com.tt.lib.advanced.services.DemoServiceManager;
import com.tt.lib.app.BaseActivity;
import com.tt.lib.app.DemoConstant;

/**
 * 登录页
 *
 * Created by jzj on 2018/3/19.
 */
@RouterUri(path = DemoConstant.LOGIN)
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(LoginActivity.this, "登录成功");
                DemoServiceManager.getAccountService().notifyLoginSuccess();
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        ToastUtils.showToast(LoginActivity.this, "登录取消");
        DemoServiceManager.getAccountService().notifyLoginCancel();
        super.onBackPressed();
    }
}
