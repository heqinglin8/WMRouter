package com.sankuai.waimai.router.demo.lib2.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

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
        Demolib2EventsManager.EVENT3().postAcrossApp("准备就绪！");
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
            Toast.makeText(IpcService.this, "外部app发来的的信息："+message, Toast.LENGTH_SHORT).show();
        }
    };
}
