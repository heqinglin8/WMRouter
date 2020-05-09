package com.sankuai.waimai.router.demo.test;

import com.sankuai.waimai.router.common.IUriAnnotationInit;
import com.sankuai.waimai.router.common.UriAnnotationHandler;

public class UriAnnotationInit_test_lib1 implements IUriAnnotationInit {
  public void init(UriAnnotationHandler handler) {
    handler.register("", "", "/lib1", "com.sankuai.waimai.router.demo.lib1.basic.DemoLibActivity1", false);
    handler.register("lib1_scheme", "lib1_host", "/exported", "com.sankuai.waimai.router.demo.lib1.basic.DemoLibActivity2", false);
  }
}
