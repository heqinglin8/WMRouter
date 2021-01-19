package com.quwan.tt.router.demo.app;

import android.os.Bundle;
import androidx.annotation.NonNull;;
import androidx.annotation.Nullable;

import com.quwan.tt.router.common.DefaultUriRequest;
import com.quwan.tt.router.core.OnCompleteListener;
import com.quwan.tt.router.core.UriRequest;
import com.tt.lib.app.BaseActivity;

/**
 * 接收所有外部跳转的ProxyActivity
 * <p>
 * Created by jzj on 2018/4/9.
 */

public class UriProxyActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DefaultUriRequest.startFromProxyActivity(this, new OnCompleteListener() {
            @Override
            public void onSuccess(@NonNull UriRequest request) {
                finish();
            }

            @Override
            public void onError(@NonNull UriRequest request, int resultCode) {
                finish();
            }
        });
    }
}