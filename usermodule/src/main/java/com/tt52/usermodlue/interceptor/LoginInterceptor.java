package com.tt52.usermodlue.interceptor;

import androidx.annotation.NonNull;;
import android.widget.Toast;

import com.quwan.tt.router.core.UriCallback;
import com.quwan.tt.router.core.UriInterceptor;
import com.quwan.tt.router.core.UriRequest;
import com.quwan.tt.router.core.UriResult;
import com.tt.lib.CustomUriResult;
import com.tt.lib.advanced.services.DemoServiceManager;
import com.tt.lib.advanced.services.IAccountService;

/**
 * Created by jzj on 2018/3/20.
 */

public class LoginInterceptor implements UriInterceptor {

    @Override
    public void intercept(@NonNull UriRequest request, @NonNull final UriCallback callback) {
        final IAccountService accountService = DemoServiceManager.getAccountService();
        if (accountService.isLogin()) {
            callback.onNext();
        } else {
            Toast.makeText(request.getContext(), "请先登录~", Toast.LENGTH_SHORT).show();
            accountService.registerObserver(new IAccountService.Observer() {
                @Override
                public void onLoginSuccess() {
                    accountService.unregisterObserver(this);
                    callback.onNext();
                }

                @Override
                public void onLoginCancel() {
                    accountService.unregisterObserver(this);
                    callback.onComplete(CustomUriResult.CODE_LOGIN_CANCEL);
                }

                @Override
                public void onLoginFailure() {
                    accountService.unregisterObserver(this);
                    callback.onComplete(CustomUriResult.CODE_LOGIN_FAILURE);
                }

                @Override
                public void onLogout() {
                    accountService.unregisterObserver(this);
                    callback.onComplete(UriResult.CODE_ERROR);
                }
            });
            DemoServiceManager.getAccountService().startLogin(request.getContext());
        }
    }
}
