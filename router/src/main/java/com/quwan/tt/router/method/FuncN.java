package com.quwan.tt.router.method;

public interface FuncN<R> extends Function {
    R call(Object... args);
}
