package org.huaiangg.mt.mtclient;

import com.igexin.sdk.PushManager;

import org.huaiangg.mt.common.app.Application;
import org.huaiangg.mt.factory.Factory;

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
        // 推送进行初始化
        PushManager.getInstance().initialize(this);
    }
}
