package org.huaiangg.mt.mtclient;

import android.util.Log;

import org.huaiangg.mt.common.app.Activity;

public class MainActivity extends Activity{
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected int getContentLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.d(TAG, "initData: 初始化Activity!");
    }

}
