package com.quwan.tt.router.demo.fragment;


import android.os.Bundle;
import androidx.annotation.NonNull;;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.quwan.tt.router.demo.basic.TestUriRequestActivity;
import com.quwan.tt.router.common.FragmentUriRequest;
import com.quwan.tt.router.core.OnCompleteListener;
import com.quwan.tt.router.core.UriRequest;
import com.quwan.tt.router.demo.R;
import com.tt.lib.ToastUtils;
import com.tt.lib.app.DemoConstant;

/**
 * Created by hailiangliao on 2017/12/25.
 */
public class DemoFragment extends Fragment {

    public static DemoFragment newInstance() {
        return new DemoFragment();
    }

    public DemoFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.host_fragment_demo_2, container, false);


        v.findViewById(R.id.btn_jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FragmentUriRequest(DemoFragment.this, DemoConstant.JUMP_ACTIVITY_1)
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

