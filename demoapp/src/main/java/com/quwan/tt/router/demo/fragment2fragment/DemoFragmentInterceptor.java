package com.quwan.tt.router.demo.fragment2fragment;
/*
 * Copyright (C) 2005-2018 Meituan Inc.All Rights Reserved.
 * Description：
 * History：
 *
 * @desc
 * @author chenmeng06
 * @date 2019/3/5
 */

import androidx.annotation.NonNull;;

import com.quwan.tt.router.core.Debugger;
import com.quwan.tt.router.core.UriCallback;
import com.quwan.tt.router.core.UriInterceptor;
import com.quwan.tt.router.core.UriRequest;

public class DemoFragmentInterceptor implements UriInterceptor {
    @Override
    public void intercept(@NonNull UriRequest request, @NonNull UriCallback callback) {
        Debugger.d("it worked");
        callback.onNext();
    }
}
