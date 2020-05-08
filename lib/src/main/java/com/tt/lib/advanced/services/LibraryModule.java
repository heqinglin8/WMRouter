package com.tt.lib.advanced.services;

/**
 * Created by jzj on 2018/3/29.
 */
public abstract class LibraryModule {

    public abstract String getModuleName();

    @Override
    public String toString() {
        return "Module: " + getModuleName();
    }
}
