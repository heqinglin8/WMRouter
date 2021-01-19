package com.quwan.tt.router.components;

import com.quwan.tt.router.core.UriHandler;

/**
 * 用于加载注解配置
 *
 * Created by jzj on 2018/4/28.
 */
public interface AnnotationLoader {

    <T extends UriHandler> void load(T handler, Class<? extends AnnotationInit<T>> initClass);
}