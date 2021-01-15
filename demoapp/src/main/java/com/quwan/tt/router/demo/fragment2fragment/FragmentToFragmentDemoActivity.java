package com.quwan.tt.router.demo.fragment2fragment;

import android.os.Bundle;

import com.quwan.tt.router.annotation.RouterUri;
import com.quwan.tt.router.common.PageAnnotationHandler;
import com.quwan.tt.router.demo.R;
import com.quwan.tt.router.fragment.v4.FragmentTransactionUriRequest;
import com.tt.lib.app.BaseActivity;
import com.tt.lib.app.DemoConstant;

/**
 * Created by hailiangliao on 2017/12/13.
 */
@RouterUri(path = DemoConstant.TEST_FRAGMENT_TO_FRAGMENT_ACTIVITY)
public class FragmentToFragmentDemoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.host_activity_fragment);
        launchFragment();
    }

    private void launchFragment() {
        new FragmentTransactionUriRequest(this, PageAnnotationHandler.SCHEME_HOST + DemoConstant.TEST_DEMO_FRAGMENT_1)
                .add(R.id.fragment_container)
                .allowingStateLoss()
                .start();
    }

}
