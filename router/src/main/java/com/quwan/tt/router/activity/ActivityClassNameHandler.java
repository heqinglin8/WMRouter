package com.quwan.tt.router.activity;

import android.content.Intent;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.quwan.tt.router.core.Debugger;
import com.quwan.tt.router.core.UriHandler;
import com.quwan.tt.router.core.UriRequest;

/**
 * 通过ClassName跳转Activity的 {@link UriHandler}
 *
 * Created by jzj on 2018/3/23.
 */

public class ActivityClassNameHandler extends AbsActivityHandler {

    @NonNull
    private final String mClassName;

    public ActivityClassNameHandler(@NonNull String className) {
        if (TextUtils.isEmpty(className)) {
            Debugger.fatal(new NullPointerException("className不应该为空"));
        }
        mClassName = className;
    }

    @NonNull
    @Override
    protected Intent createIntent(@NonNull UriRequest request) {
        return new Intent().setClassName(request.getContext(), mClassName);
    }

    @Override
    public String toString() {
        return "ActivityHandler (" + mClassName + ")";
    }
}