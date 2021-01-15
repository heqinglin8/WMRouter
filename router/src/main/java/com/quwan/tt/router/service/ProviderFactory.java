package com.quwan.tt.router.service;

import androidx.annotation.NonNull;;

import com.quwan.tt.router.utils.ProviderPool;

public class ProviderFactory implements IFactory {

    public static final IFactory INSTANCE = new ProviderFactory();

    private ProviderFactory() {

    }

    @NonNull
    @Override
    public <T> T create(@NonNull Class<T> clazz) throws Exception {
        return ProviderPool.create(clazz);
    }
}
