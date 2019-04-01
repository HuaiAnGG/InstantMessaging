package org.huaiangg.mt.factory.presenter.contact;

import org.huaiangg.mt.factory.model.card.UserCard;
import org.huaiangg.mt.factory.presenter.BaseContract;

/**
 * @description: 关注的接口定义
 * @author: HuaiAngg
 * @create: 2019-04-01 0:32
 */
public interface FollowContract {
    // 任务调度者
    interface Presenter extends BaseContract.Presenter {
        // 关注一个人
        void follow(String id);
    }

    interface View extends BaseContract.View<Presenter> {
        // 成功的情况下返回一个用户的信息
        void onFollowSucceed(UserCard userCard);
    }
}
