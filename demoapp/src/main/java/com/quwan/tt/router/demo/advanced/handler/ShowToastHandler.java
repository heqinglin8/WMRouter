package com.quwan.tt.router.demo.advanced.handler;

import androidx.annotation.NonNull;;
import android.widget.Toast;

import com.quwan.tt.router.annotation.RouterUri;
import com.quwan.tt.router.core.UriCallback;
import com.quwan.tt.router.core.UriHandler;
import com.quwan.tt.router.core.UriRequest;
import com.quwan.tt.router.core.UriResult;
import com.tt.lib.app.DemoConstant;

@RouterUri(path = DemoConstant.SHOW_TOAST_HANDLER)
public class ShowToastHandler extends UriHandler {

    @Override
    protected boolean shouldHandle(@NonNull UriRequest request) {
        return true;
    }

    @Override
    protected void handleInternal(@NonNull UriRequest request, @NonNull UriCallback callback) {
        Toast.makeText(request.getContext(), "TestHandler", Toast.LENGTH_LONG).show();
        callback.onComplete(UriResult.CODE_SUCCESS);
    }
}