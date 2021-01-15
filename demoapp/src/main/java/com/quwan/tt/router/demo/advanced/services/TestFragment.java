package com.quwan.tt.router.demo.advanced.services;

import androidx.fragment.app.Fragment;

import com.quwan.tt.router.annotation.RouterService;
import com.tt.lib.app.DemoConstant;

/**
 * Created by jzj on 2018/4/19.
 */
@RouterService(interfaces = Fragment.class, key = DemoConstant.TEST_FRAGMENT)
public class TestFragment extends Fragment {

}
