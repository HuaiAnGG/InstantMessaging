package org.huaiangg.mt.factory.presenter.account;

import org.huaiangg.mt.factory.presenter.BaseContract;

/**
 * @description:
 * @author: HuaiAngg
 * @create: 2019-03-24 16:21
 */
public interface LoginContract {
    interface View extends BaseContract.View<Presenter> {
        // 登录成功
        void loginSuccess();
    }


    interface Presenter extends BaseContract.Presenter {
        // 发起一个登录
        void login(String phone, String password);
    }

}