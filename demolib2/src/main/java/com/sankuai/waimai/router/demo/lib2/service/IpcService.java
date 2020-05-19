package com.sankuai.waimai.router.demo.lib2.service;

import android.app.Service;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.tt52.demolib2_export.Demolib2EventsManager;

/**
 * Created by liaohailiang on 2019/3/26.
 */
public class IpcService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Demolib2EventsManager.EVENT3().observeForever(observer2);
        Log.e("hql","IpcService onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    private Observer<String> observer2 = new Observer<String>() {
        @Override
        public void onChanged(@Nullable String message) {
            Toast.makeText(IpcService.this, "跨进程接收信息："+message, Toast.LENGTH_SHORT).show();
        }
    };
}
