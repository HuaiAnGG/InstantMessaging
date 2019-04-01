package org.huaiangg.mt.mtclient.activities;

import android.content.Context;

import org.huaiangg.mt.common.app.Activity;
import org.huaiangg.mt.factory.model.Author;
import org.huaiangg.mt.mtclient.R;

public class MessageActivity extends Activity {

    /**
     * 显示人的聊天界面
     *
     * @param context 上下文
     * @param author  人的信息
     */
    public static void show(Context context, Author author) {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_message;
    }

}
