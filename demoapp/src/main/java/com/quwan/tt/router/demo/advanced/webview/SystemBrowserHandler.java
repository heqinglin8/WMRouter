package com.quwan.tt.router.demo.advanced.webview;

import android.content.Intent;
import androidx.annotation.NonNull;;

import com.quwan.tt.router.annotation.RouterRegex;
import com.quwan.tt.router.core.UriCallback;
import com.quwan.tt.router.core.UriHandler;
import com.quwan.tt.router.core.UriRequest;
import com.quwan.tt.router.core.UriResult;
import com.tt.lib.app.DemoConstant;

/**
 * 跳转到系统自带浏览器
 *
 * Created by jzj on 2018/3/26.
 */
@RouterRegex(regex = DemoConstant.HTTP_URL_REGEX)
public class SystemBrowserHandler extends UriHandler {

    @Override
    protected boolean shouldHandle(@NonNull UriRequest request) {
        return true;
    }

    @Override
    protected void handleInternal(@NonNull UriRequest request, @NonNull UriCallback callback) {
        try {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(request.getUri());
            request.getContext().startActivity(intent);
            callback.onComplete(UriResult.CODE_SUCCESS);
        } catch (Exception e) {
            callback.onComplete(UriResult.CODE_ERROR);
        }
    }
}
