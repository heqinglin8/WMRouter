package com.quwan.tt.router.demo.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import com.quwan.tt.router.annotation.RouterUri;
import com.quwan.tt.router.demo.R;
import com.tt.lib.app.BaseActivity;
import com.tt.lib.app.DemoConstant;

/**
 * Created by hailiangliao on 2017/12/13.
 */
@RouterUri(path = DemoConstant.JUMP_FRAGMENT_ACTIVITY)
public class FragmentDemoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.host_activity_fragment);
        launchFragment();
    }

    private void launchFragment() {
        Fragment fragment = DemoFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                fragment).commit();
    }
}
