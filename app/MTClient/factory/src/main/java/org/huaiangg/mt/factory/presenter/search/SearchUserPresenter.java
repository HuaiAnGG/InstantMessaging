package org.huaiangg.mt.factory.presenter.search;

import net.qiujuer.genius.kit.handler.Run;
import net.qiujuer.genius.kit.handler.runable.Action;

import org.huaiangg.mt.factory.data.DataSource;
import org.huaiangg.mt.factory.data.helper.UserHelper;
import org.huaiangg.mt.factory.model.card.UserCard;
import org.huaiangg.mt.factory.presenter.BasePresenter;

import java.util.List;

import retrofit2.Call;

/**
 * @description:
 * @author: HuaiAngg
 * @create: 2019-03-31 19:43
 */
public class SearchUserPresenter extends BasePresenter<SearchContract.UserView>
        implements SearchContract.Presenter, DataSource.Callback<List<UserCard>> {
    private Call searchCall;

    public SearchUserPresenter(SearchContract.UserView view) {
        super(view);
    }

    @Override
    public void search(String content) {
        start();

        Call call = searchCall;
        if (call != null && !call.isCanceled()) {
            // 如果有上一次的请求，并且没有取消，
            // 则调用取消请求操作
            call.cancel();
        }

        searchCall = UserHelper.search(content, this);
    }

    @Override
    public void onDataLoaded(final List<UserCard> userCards) {
        // 搜索成功
        final SearchContract.UserView view = getView();
        if(view!=null){
            Run.onUiAsync(new Action() {
                @Override
                public void call() {
                    view.onSearchDone(userCards);
                }
            });
        }
    }

    @Override
    public void onDataNotAvailable(final int strRes) {
        // 搜索失败
        final SearchContract.UserView view = getView();
        if(view!=null){
            Run.onUiAsync(new Action() {
                @Override
                public void call() {
                    view.showError(strRes);
                }
            });
        }
    }
}
