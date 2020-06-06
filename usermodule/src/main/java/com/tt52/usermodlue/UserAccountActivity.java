package com.tt52.usermodlue;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.sankuai.waimai.router.annotation.RouterUri;
import com.tt.lib.advanced.services.DemoServiceManager;
import com.tt.lib.app.BaseActivity;
import com.tt.lib.app.DemoConstant;
import com.tt52.usermodlue.interceptor.LoginInterceptor;

/**
 * 用户账户页，需要先登录
 *
 * Created by jzj on 2018/3/19.
 */
@RouterUri(path = DemoConstant.ACCOUNT_WITH_LOGIN_INTERCEPTOR,
        interceptors = LoginInterceptor.class)
public class UserAccountActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("我的账户");
        setContentView(R.layout.usermodule_activity_button);
        Button button = findViewById(R.id.button);
        button.setText("退出登录");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DemoServiceManager.getAccountService().notifyLogout();
                finish();
            }
        });
    }
}
