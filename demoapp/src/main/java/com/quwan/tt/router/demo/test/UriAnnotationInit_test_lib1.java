package com.quwan.tt.router.demo.test;

import com.quwan.tt.router.common.IUriAnnotationInit;
import com.quwan.tt.router.common.UriAnnotationHandler;

public class UriAnnotationInit_test_lib1 implements IUriAnnotationInit {
  public void init(UriAnnotationHandler handler) {
    handler.register("", "", "/lib1", "com.quwan.tt.router.demo.lib1.basic.DemoLibActivity1", false);
    handler.register("lib1_scheme", "lib1_host", "/exported", "com.quwan.tt.router.demo.lib1.basic.DemoLibActivity2", false);
  }
}
