package org.huaiangg.mt.factory.presenter.contact;

import net.qiujuer.genius.kit.handler.Run;
import net.qiujuer.genius.kit.handler.runable.Action;

import org.huaiangg.mt.factory.Factory;
import org.huaiangg.mt.factory.data.helper.UserHelper;
import org.huaiangg.mt.factory.model.db.User;
import org.huaiangg.mt.factory.persistence.Account;
import org.huaiangg.mt.factory.presenter.BasePresenter;

/**
 * @description:
 * @author: HuaiAngg
 * @create: 2019-04-01 0:44
 */
public class PersonalPresenter extends BasePresenter<PersonalContract.View>
        implements PersonalContract.Presenter {

    private User user;

    public PersonalPresenter(PersonalContract.View view) {
        super(view);
    }


    @Override
    public void start() {
        super.start();

        // 个人界面用户数据优先从网络拉取
        Factory.runOnAsync(()-> {
            PersonalContract.View view = getView();
            if (view != null) {
                String id = view.getUserId();
                User user = UserHelper.searchFirstOfNet(id);
                onLoaded(view, user);
            }
        });

    }


    private void onLoaded(final PersonalContract.View view, final User user) {
        this.user = user;
        // 是否就是我自己
        final boolean isSelf = user.getId().equalsIgnoreCase(Account.getUserId());
        // 是否已经关注
        final boolean isFollow = isSelf || user.isFollow();
        // 已经关注同时不是自己才能聊天
        final boolean allowSayHello = isFollow && !isSelf;

        // 切换到Ui线程
        Run.onUiAsync(new Action() {
            @Override
            public void call() {
                view.onLoadDone(user);
                view.setFollowStatus(isFollow);
                view.allowSayHello(allowSayHello);
            }
        });
    }

    @Override
    public User getUserPersonal() {
        return user;
    }
}
