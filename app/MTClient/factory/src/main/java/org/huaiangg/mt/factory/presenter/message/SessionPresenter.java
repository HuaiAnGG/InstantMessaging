package org.huaiangg.mt.factory.presenter.message;

import android.support.v7.util.DiffUtil;

import org.huaiangg.mt.factory.data.message.SessionDataSource;
import org.huaiangg.mt.factory.data.message.SessionRepository;
import org.huaiangg.mt.factory.model.db.Session;
import org.huaiangg.mt.factory.presenter.BaseSourcePresenter;
import org.huaiangg.mt.factory.utils.DiffUiDataCallback;

import java.util.List;

/**
 * @description: 最近聊天列表的Presenter
 * @author: HuaiAngg
 * @create: 2019-04-09 16:21
 */
public class SessionPresenter extends BaseSourcePresenter<Session, Session,
        SessionDataSource, SessionContract.View> implements SessionContract.Presenter {

    public SessionPresenter(SessionContract.View view) {
        super(new SessionRepository(), view);
    }

    @Override
    public void onDataLoaded(List<Session> sessions) {
        SessionContract.View view = getView();
        if (view == null)
            return;

        // 差异对比
        List<Session> old = view.getRecyclerAdapter().getItems();
        DiffUiDataCallback<Session> callback = new DiffUiDataCallback<>(old, sessions);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);

        // 刷新界面
        refreshData(result, sessions);
    }
}
