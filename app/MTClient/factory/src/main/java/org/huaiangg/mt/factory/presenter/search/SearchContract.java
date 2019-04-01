package org.huaiangg.mt.factory.presenter.search;

import org.huaiangg.mt.factory.model.card.GroupCard;
import org.huaiangg.mt.factory.model.card.UserCard;
import org.huaiangg.mt.factory.presenter.BaseContract;

import java.util.List;

/**
 * @description: 搜索的契约类
 * @author: HuaiAngg
 * @create: 2019-03-31 19:40
 */
public interface SearchContract {
    interface Presenter extends BaseContract.Presenter {
        // 搜索内容
        void search(String content);
    }

    // 搜索人的界面
    interface UserView extends BaseContract.View<Presenter> {
        void onSearchDone(List<UserCard> userCards);
    }

    // 搜索群的界面
    interface GroupView extends BaseContract.View<Presenter> {
        void onSearchDone(List<GroupCard> groupCards);
    }

}
