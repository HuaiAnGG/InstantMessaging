package org.huaiangg.mt.factory.presenter.user;

import org.huaiangg.mt.factory.presenter.BaseContract;

/**
 * @description: 更新用户信息的基本的契约
 * @author: HuaiAngg
 * @create: 2019-03-24 16:25
 */
public interface UpdateInfoContract {
    interface Presenter extends BaseContract.Presenter {
        // 更新
        void update(String photoFilePath, String desc, boolean isMan);
    }

    interface View extends BaseContract.View<Presenter> {
        // 回调成功
        void updateSucceed();
    }
}
