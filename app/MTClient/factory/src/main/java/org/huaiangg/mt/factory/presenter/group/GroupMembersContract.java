package org.huaiangg.mt.factory.presenter.group;

import org.huaiangg.mt.factory.model.db.view.MemberUserModel;
import org.huaiangg.mt.factory.presenter.BaseContract;

/**
 * @description: 群成员的契约
 * @author: HuaiAngg
 * @create: 2019-04-09 16:12
 */
public interface GroupMembersContract {
    interface Presenter extends BaseContract.Presenter {
        // 具有一个刷新的方法
        void refresh();
    }

    // 界面
    interface View extends BaseContract.RecyclerView<Presenter, MemberUserModel> {
        // 获取群的ID
        String getGroupId();
    }
}
