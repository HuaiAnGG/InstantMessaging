package org.huaiangg.mt.mtclient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.igexin.sdk.PushManager;

import org.huaiangg.mt.common.app.Application;
import org.huaiangg.mt.factory.Factory;

import static android.support.constraint.Constraints.TAG;

/**
 * @description:
 * @author: HuaiAngg
 * @create: 2019-03-24 16:52
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 调用Factory进行初始化
        Factory.setup();

        // 注册生命周期
        registerActivityLifecycleCallbacks(new PushInitializeLifecycle());
    }

    /**
     * 个推服务在部分手机上极易容易回收，可放Resumed中唤起
     */
    private class PushInitializeLifecycle implements ActivityLifecycleCallbacks {

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {
            // 推送进行初始化
            Log.d(TAG, "onActivityResumed: 推送进行初始化");
            PushManager.getInstance().initialize(App.this, AppPushService.class);
            // 推送注册消息接收服务
            Log.d(TAG, "onActivityResumed: 推送注册消息接收服务");
            PushManager.getInstance().registerPushIntentService(App.this, AppMessageReceiverService.class);
        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            PushManager.getInstance().stopService(App.this);
        }
    }
}
