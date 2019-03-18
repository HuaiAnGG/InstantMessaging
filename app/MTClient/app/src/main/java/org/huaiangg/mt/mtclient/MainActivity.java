package org.huaiangg.mt.mtclient;

import android.widget.TextView;

import org.huaiangg.mt.common.app.Activity;

import butterknife.BindView;

public class MainActivity extends Activity {
    @BindView(R.id.txt_test)
    TextView mtestText;

    @Override
    protected int getContentLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        super.initData();
        mtestText.setText("Hello World!");
    }
}
