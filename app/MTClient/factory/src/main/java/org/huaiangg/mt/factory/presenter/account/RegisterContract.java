package org.huaiangg.mt.factory.presenter.account;

import org.huaiangg.mt.factory.presenter.BaseContract;

/**
 * @description:
 * @author: HuaiAngg
 * @create: 2019-03-24 16:23
 */
public interface RegisterContract {
    interface View extends BaseContract.View<Presenter> {
        // 注册成功
        void registerSuccess();
    }

    interface Presenter extends BaseContract.Presenter {
        // 发起一个注册
        void register(String phone, String name, String password);

        // 检查手机号是否正确
        boolean checkMobile(String phone);
    }

}
