package com.quwan.tt.router.demo.advanced.webview;

import android.net.Uri;
import androidx.annotation.NonNull;;

import com.quwan.tt.router.Router;
import com.quwan.tt.router.core.UriCallback;
import com.quwan.tt.router.core.UriInterceptor;
import com.quwan.tt.router.core.UriRequest;
import com.quwan.tt.router.utils.RouterUtils;
import com.tt.lib.app.DemoConstant;

import java.util.HashMap;

/**
 * 给URL添加共通参数
 *
 * Created by jzj on 2018/3/27.
 */

public class CommonParamInterceptor implements UriInterceptor {

    private HashMap<String, String> mCommonParams;

    @Override
    public void intercept(@NonNull UriRequest request, @NonNull UriCallback callback) {
        initIfNeeded();
        Uri uri = RouterUtils.appendParams(request.getUri(), mCommonParams);
        request.setUri(uri);
        callback.onNext();
    }

    private void initIfNeeded() {
        if (mCommonParams == null) {
            mCommonParams = new HashMap<>();
            mCommonParams.put("platform", "android");
            mCommonParams.put("version",
                    String.valueOf((int) Router.callMethod(DemoConstant.GET_VERSION_CODE)));
        }
    }
}
