package org.huaiangg.mt.factory.presenter.group;

import org.huaiangg.mt.factory.model.db.Group;
import org.huaiangg.mt.factory.presenter.BaseContract;

/**
 * @description: 我的群列表契约
 * @author: HuaiAngg
 * @create: 2019-04-09 16:14
 */
public interface GroupsContract {
    // 什么都不需要额外定义，开始就是调用start即可
    interface Presenter extends BaseContract.Presenter {

    }

    // 都在基类完成了
    interface View extends BaseContract.RecyclerView<Presenter, Group> {

    }
}