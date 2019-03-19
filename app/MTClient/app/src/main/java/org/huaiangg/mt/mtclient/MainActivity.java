package org.huaiangg.mt.mtclient;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.huaiangg.mt.common.app.Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity implements IView {
    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.txt_test)
    TextView mTestText;
    @BindView(R.id.edit_query)
    EditText mEditQuery;

    private IPresenter mPresenter;

    @Override
    protected int getContentLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.d(TAG, "initData: 初始化Activity!");
        // 初始化Presenter
        mPresenter = new Presenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_submit)
    public void onViewClicked() {
        mPresenter.search();
    }

    /**
     * 得到输入的文本字符串
     * @return 输入的文本
     */
    @Override
    public String getInputString() {
        return mEditQuery.getText().toString();
    }

    /**
     * 设置显示的内容
     * @param result 显示内容
     */
    @Override
    public void setResultString(String result) {
        mTestText.setText(result);
    }
}
