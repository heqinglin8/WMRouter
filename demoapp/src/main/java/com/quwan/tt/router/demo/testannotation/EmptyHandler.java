package com.quwan.tt.router.demo.testannotation;

import androidx.annotation.NonNull;;

import com.quwan.tt.router.core.UriCallback;
import com.quwan.tt.router.core.UriHandler;
import com.quwan.tt.router.core.UriRequest;

/**
 * Created by jzj on 2018/3/26.
 */

public class EmptyHandler extends UriHandler {

    @Override
    protected boolean shouldHandle(@NonNull UriRequest request) {
        return false;
    }

    @Override
    protected void handleInternal(@NonNull UriRequest request, @NonNull UriCallback callback) {

    }
}
