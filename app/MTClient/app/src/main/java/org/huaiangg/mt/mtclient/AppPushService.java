package org.huaiangg.mt.mtclient;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.igexin.sdk.GTServiceManager;

/**
 * @description: 个推推送SDK新版本Service支持
 *              该Service用以与个推服务器通讯，维持长链接；所以需要独立进程
 *              当收到消息后可以通过广播方式传递出来，或者通过GTIntentService传递消息出来
 *              比如：{@link AppMessageReceiverService}
 * @author: HuaiAngg
 * @create: 2019-03-25 10:21
 */
public class AppPushService extends Service {

    private static final String TAG = AppPushService.class.getSimpleName();

    public AppPushService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: 个推推送SDK新版本Service启动！");
        GTServiceManager.getInstance().onCreate(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        return GTServiceManager.getInstance().onStartCommand(this, intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return GTServiceManager.getInstance().onBind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        GTServiceManager.getInstance().onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        GTServiceManager.getInstance().onLowMemory();
    }
}
