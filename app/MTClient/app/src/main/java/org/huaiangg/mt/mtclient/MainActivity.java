package org.huaiangg.mt.mtclient;

import android.util.Log;
import android.widget.TextView;

import org.huaiangg.mt.common.app.Activity;

import butterknife.BindView;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.txt_test)
    TextView mTestText;

    @Override
    protected int getContentLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.d(TAG, "initData: 初始化Activity!");
        mTestText.setText("Hello0987654");
    }
}
