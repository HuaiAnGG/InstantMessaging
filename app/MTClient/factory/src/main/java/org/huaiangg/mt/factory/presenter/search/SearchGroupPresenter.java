package org.huaiangg.mt.factory.presenter.search;

import org.huaiangg.mt.factory.presenter.BasePresenter;

/**
 * @description:
 * @author: HuaiAngg
 * @create: 2019-03-31 19:43
 */
public class SearchGroupPresenter extends BasePresenter<SearchContract.GroupView>
        implements SearchContract.Presenter {
    public SearchGroupPresenter(SearchContract.GroupView view) {
        super(view);
    }

    @Override
    public void search(String content) {

    }
}
