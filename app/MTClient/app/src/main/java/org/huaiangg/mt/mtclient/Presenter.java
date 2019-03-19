package org.huaiangg.mt.mtclient;

import android.text.TextUtils;
import android.view.View;

/**
 * @description:
 * @author: HuaiAngg
 * @create: 2019-03-19 20:22
 */
public class Presenter implements IPresenter{
    private IView mView;

    public Presenter(IView view){
        this.mView = view;
    }

    @Override
    public void search() {
        // 开启界面Loadding
        String inputString = mView.getInputString();
        // 判空操作
        if (TextUtils.isEmpty(inputString)) {
            return;
        }

        int hashCode = inputString.hashCode();

        IUserService service = new UserService();
        String serviceResult = service.search(inputString.hashCode());

        String result = "Result:" + inputString +"---" + serviceResult;

        // 关闭界面Loadding
        mView.setResultString(result);
    }
}
