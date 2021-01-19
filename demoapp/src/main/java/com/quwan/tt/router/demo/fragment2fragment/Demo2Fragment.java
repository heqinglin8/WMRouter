package com.quwan.tt.router.demo.fragment2fragment;


import android.os.Bundle;
import androidx.annotation.NonNull;;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quwan.tt.router.annotation.RouterPage;
import com.quwan.tt.router.common.FragmentUriRequest;
import com.quwan.tt.router.core.OnCompleteListener;
import com.quwan.tt.router.core.UriRequest;
import com.quwan.tt.router.demo.R;
import com.quwan.tt.router.demo.basic.TestUriRequestActivity;
import com.tt.lib.ToastUtils;
import com.tt.lib.app.DemoConstant;

/**
 * Created by hailiangliao on 2017/12/25.
 */
@RouterPage(path = DemoConstant.TEST_DEMO_FRAGMENT_2, interceptors = DemoFragmentInterceptor.class)
public class Demo2Fragment extends Fragment {

    public static Demo2Fragment newInstance() {
        return new Demo2Fragment();
    }

    public Demo2Fragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.host_fragment_demo_2, container, false);
        String message = getArguments().getString("message","");
        TextView textView = v.findViewById(R.id.text_message);
        textView.setText("get msg:" + message);

        v.findViewById(R.id.btn_jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FragmentUriRequest(Demo2Fragment.this, DemoConstant.JUMP_ACTIVITY_1)
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
            }
        });



        return v;
    }
}