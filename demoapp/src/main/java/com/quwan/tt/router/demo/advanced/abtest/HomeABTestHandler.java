package com.quwan.tt.router.demo.advanced.abtest;

import android.content.Intent;
import androidx.annotation.NonNull;;

import com.quwan.tt.router.annotation.RouterUri;
import com.quwan.tt.router.activity.AbsActivityHandler;
import com.quwan.tt.router.core.UriRequest;
import com.tt.lib.app.DemoConstant;

@RouterUri(path = DemoConstant.HOME_AB_TEST)
public class HomeABTestHandler extends AbsActivityHandler {

    @NonNull
    @Override
    protected Intent createIntent(@NonNull UriRequest request) {
        if (FakeABTestService.getHomeABStrategy().equals("A")) {
            return new Intent(request.getContext(), HomeActivityA.class);
        } else {
            return new Intent(request.getContext(), HomeActivityB.class);
        }

    }
}
