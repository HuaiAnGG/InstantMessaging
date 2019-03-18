package org.huaiangg.mt.common.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import butterknife.ButterKnife;

/**
 * @description:
 * @author: HuaiAngg
 * @create: 2019-03-18 19:52
 */
public abstract class Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 在界面未初始化之前调用初始化窗口
        initWindows();

        if (initArgs(getIntent().getExtras())) {
            int layoutID = getContentLayoutID();
            // 加载布局ID
            setContentView(layoutID);

            initWidget();
            initData();
        } else {
            finish();
        }
    }

    /**
     * 初始化相关参数
     */
    protected void initWindows() {

    }

    /**
     * 初始化相关参数
     * @param bundle 参数Bundle
     * @return 如果参数正确返回true 错误返回false
     */
    protected boolean initArgs(Bundle bundle) {
        return true;
    }

    /**
     * 得到当前界面的资源文件ID
     * @return 资源文件ID
     */
    protected abstract int getContentLayoutID();

    /**
     * 初始化控件
     */
    protected void initWidget() {
        ButterKnife.bind(this);
    }

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 界面导航返回事件
     * @return
     */
    @Override
    public boolean onSupportNavigateUp() {
        // Finsish当前界面
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        // 得到当前Activity下的所有Fragment
        @SuppressLint("RestrictedApi")
        List<android.support.v4.app.Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null && fragments.size() > 0){
            for (Fragment fragment : fragments){
                // 判断是否为我们能够处理的Fragment类型
                if (fragment instanceof org.huaiangg.mt.common.app.Fragment){
                    // 判断是否拦截了返回按钮
                    if (((org.huaiangg.mt.common.app.Fragment) fragment).onBackpressed()) {
                        // 如果有则返回
                        return;
                    }
                }
            }
        }
        super.onBackPressed();
        finish();
    }
}
