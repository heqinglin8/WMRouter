package com.quwan.tt.router.demo.advanced.webview;

import android.net.Uri;
import androidx.annotation.NonNull;;

import com.quwan.tt.router.annotation.RouterUri;
import com.quwan.tt.router.core.UriCallback;
import com.quwan.tt.router.core.UriHandler;
import com.quwan.tt.router.core.UriRequest;
import com.quwan.tt.router.core.UriResult;
import com.tt.lib.app.DemoConstant;

/**
 * Created by jzj on 2018/3/27.
 */
@RouterUri(path = DemoConstant.BROWSER)
public class BrowserSchemeHandler extends UriHandler {

    @Override
    protected boolean shouldHandle(@NonNull UriRequest request) {
        return isHttpOrHttps(getUrl(request));
    }

    @Override
    protected void handleInternal(@NonNull UriRequest request, @NonNull UriCallback callback) {
        Uri url = getUrl(request);
        if (url == null) {
            callback.onComplete(UriResult.CODE_ERROR);
        } else {
            request.setUri(url);
            callback.onComplete(UriResult.CODE_REDIRECT);
        }
    }

    private static Uri getUrl(@NonNull UriRequest request) {
        String url = request.getUri().getQueryParameter("url");
        return url == null ? null : Uri.parse(url);
    }

    /**
     * 是不是Http(s)链接
     */
    private static boolean isHttpOrHttps(Uri uri) {
        if (uri == null) return false;
        final String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }
}
