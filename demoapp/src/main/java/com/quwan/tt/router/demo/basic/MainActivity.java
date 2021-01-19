package com.quwan.tt.router.demo.basic;

import android.os.Bundle;
import androidx.annotation.NonNull;;
import androidx.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.quwan.tt.router.Router;
import com.quwan.tt.router.common.DefaultUriRequest;
import com.quwan.tt.router.core.OnCompleteListener;
import com.quwan.tt.router.core.UriRequest;
import com.quwan.tt.router.demo.R;
import com.tt.lib.ToastUtils;
import com.tt.lib.app.BaseActivity;
import com.tt.lib.app.DemoConstant;

/**
 * 基本用法Demo
 * <p>
 * Created by jzj on 2018/4/19.
 */

public class MainActivity extends BaseActivity {

    public static final String[] URIS = {
            // 基本页面跳转，支持不配置Scheme、Host，支持多个path
            DemoConstant.JUMP_ACTIVITY_1,
            DemoConstant.JUMP_ACTIVITY_2,

            // Kotlin
            DemoConstant.KOTLIN,

            // request跳转测试
            DemoConstant.JUMP_WITH_REQUEST,

            // 自定义Scheme、Host测试；外部跳转测试
            DemoConstant.DEMO_SCHEME + "://" + DemoConstant.DEMO_HOST
                    + DemoConstant.EXPORTED_PATH,
            DemoConstant.DEMO_SCHEME + "://" + DemoConstant.DEMO_HOST
                    + DemoConstant.NOT_EXPORTED_PATH,

            // Library工程测试
            DemoConstant.TEST_LIB1,
            DemoConstant.TEST_LIB2,

            // 拨打电话
            DemoConstant.TEL,

            // 降级策略
            DemoConstant.TEST_NOT_FOUND,

            // Fragment test
            DemoConstant.JUMP_FRAGMENT_ACTIVITY,

            // Fragment to Fragment test
            DemoConstant.TEST_FRAGMENT_TO_FRAGMENT_ACTIVITY,

            // 高级Demo页面
            DemoConstant.ADVANCED_DEMO,

            DemoConstant.LIB1_SCHEME + "://" + DemoConstant.LIB1_HOST
                    + DemoConstant.EXPORTED_PATH,

            DemoConstant.FLUTTER_MAIN,

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.host_activity_main);

        LinearLayout container = findViewById(R.id.layout_container);
        for (final String uri : URIS) {
            Button button = new Button(this);
            button.setAllCaps(false);
            button.setText(uri);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    jump(uri);
                }
            });
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            container.addView(button, params);
        }
    }

    private void jump(String uri) {
        if (DemoConstant.JUMP_WITH_REQUEST.equals(uri)) {
            new DefaultUriRequest(this, uri)
                    .activityRequestCode(100)
                    .putExtra(TestUriRequestActivity.INTENT_TEST_INT, 1)
                    .putExtra(TestUriRequestActivity.INTENT_TEST_STR, "str")
                    .overridePendingTransition(R.anim.host_enter_activity, R.anim.host_exit_activity)
                    .onComplete(new OnCompleteListener() {
                        @Override
                        public void onSuccess(@NonNull UriRequest request) {
                            ToastUtils.showToast(request.getContext(), "跳转成功");
                        }

                        @Override
                        public void onError(@NonNull UriRequest request, int resultCode) {

                        }
                    })
                    .start();
        }else if(DemoConstant.FLUTTER_MAIN.equals(uri)){
//            FlutterActivity.createDefaultIntent(this);
        } else {
            Router.startUri(this, uri);
        }
    }
}