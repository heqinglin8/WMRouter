package com.quwan.tt.router.demo.test.service;

import com.quwan.tt.router.common.IUriAnnotationInit;
import com.quwan.tt.router.demo.test.UriAnnotationInit_test_lib1;
import com.quwan.tt.router.service.ServiceLoader;

/*
    注入的测试类，用于测试
 */
public class ServiceInit_test_lib1 {
  public static void init() {
    ServiceLoader.put(IUriAnnotationInit.class, "com.quwan.tt.router.demo.test.UriAnnotationInit_test_lib1", UriAnnotationInit_test_lib1.class, false);
  }
}
