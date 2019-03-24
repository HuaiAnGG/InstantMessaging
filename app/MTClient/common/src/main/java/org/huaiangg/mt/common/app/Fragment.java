package org.huaiangg.mt.common.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @description: Fragment基类
 * @author: HuaiAngg
 * @create: 2019-03-18 19:53
 */
public abstract class Fragment extends android.support.v4.app.Fragment {
    protected View mRoot;
    protected Unbinder mRootUnbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // 初始化参数
        initArgs(getArguments());
    }

    /**
     * 初始化相关参数
     * @param bundle 参数Bundle
     * @return 如果参数正确返回true 错误返回false
     */
    protected void initArgs(Bundle bundle) {

    }

    // 重写创建界面函数
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRoot == null) {
            int layoutID = getContentLayoutID();
            // 初始化当前的根布局
            View root = inflater.inflate(layoutID, container, false);
            initWidget(root);
            mRoot = root;
        } else {
            // 如果当前根布局不为空 就把root从其父控件中移除
            if (mRoot.getParent() != null) {
                ((ViewGroup) mRoot.getParent()).removeView(mRoot);
            }
        }

        return mRoot;
    }

    // 界面创建完成事件
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // View完成后，初始化数据
        initData();
    }

    /**
     * 得到当前界面的资源文件ID
     *
     * @return 资源文件ID
     */
    protected abstract int getContentLayoutID();

    /**
     * 初始化控件
     */
    protected void initWidget(View root) {
        mRootUnbinder = ButterKnife.bind(this, root);
    }

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 返回按键触发时调用
     * @return 返回True代表返回逻辑已经处理，不需要Activity处理逻辑
     *          返回false代表逻辑没有处理，需要Activity执行逻辑处理
     */
    public boolean onBackpressed() {
        return true;
    }
}
