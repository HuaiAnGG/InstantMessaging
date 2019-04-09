package org.huaiangg.mt.factory.presenter.message;

import org.huaiangg.mt.factory.model.db.Session;
import org.huaiangg.mt.factory.presenter.BaseContract;

/**
 * @description:
 * @author: HuaiAngg
 * @create: 2019-04-09 16:20
 */
public interface SessionContract {
    // 什么都不需要额外定义，开始就是调用start即可
    interface Presenter extends BaseContract.Presenter {

    }

    // 都在基类完成了
    interface View extends BaseContract.RecyclerView<Presenter, Session> {

    }
}
