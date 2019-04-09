package org.huaiangg.mt.factory.presenter.group;

import org.huaiangg.mt.factory.Factory;
import org.huaiangg.mt.factory.data.helper.GroupHelper;
import org.huaiangg.mt.factory.model.db.view.MemberUserModel;
import org.huaiangg.mt.factory.presenter.BaseRecyclerPresenter;

import java.util.List;

/**
 * @description:
 * @author: HuaiAngg
 * @create: 2019-04-09 16:13
 */
public class GroupMembersPresenter extends BaseRecyclerPresenter<MemberUserModel, GroupMembersContract.View>
        implements GroupMembersContract.Presenter {

    public GroupMembersPresenter(GroupMembersContract.View view) {
        super(view);
    }

    @Override
    public void refresh() {
        // 显示Loading
        start();

        // 异步加载
        Factory.runOnAsync(loader);
    }

    private Runnable loader = new Runnable() {
        @Override
        public void run() {
            GroupMembersContract.View view = getView();
            if (view == null)
                return;

            String groupId = view.getGroupId();

            // 传递数量为-1 代表查询所有
            List<MemberUserModel> models = GroupHelper.getMemberUsers(groupId, -1);

            refreshData(models);
        }
    };
}
