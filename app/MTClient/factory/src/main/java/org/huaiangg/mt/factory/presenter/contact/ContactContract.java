package org.huaiangg.mt.factory.presenter.contact;

import org.huaiangg.mt.factory.model.db.User;
import org.huaiangg.mt.factory.presenter.BaseContract;

/**
 * @description:
 * @author: HuaiAngg
 * @create: 2019-04-01 0:43
 */
public interface ContactContract {
    // 什么都不需要额外定义，开始就是调用start即可
    interface Presenter extends BaseContract.Presenter {

    }

    // 都在基类完成了
    interface View extends BaseContract.RecyclerView<Presenter, User> {

    }
}
