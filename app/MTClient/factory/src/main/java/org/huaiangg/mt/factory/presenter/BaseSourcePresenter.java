package org.huaiangg.mt.factory.presenter;

import org.huaiangg.mt.factory.data.DataSource;
import org.huaiangg.mt.factory.data.DbDataSource;

import java.util.List;

/**
 * @description: 基础的仓库源的Presenter定义
 * @author: HuaiAngg
 * @create: 2019-04-09 16:23
 */
public abstract class BaseSourcePresenter<Data, ViewModel,
        Source extends DbDataSource<Data>,
        View extends BaseContract.RecyclerView>
        extends BaseRecyclerPresenter<ViewModel, View>
        implements DataSource.SucceedCallback<List<Data>> {

    protected Source mSource;

    public BaseSourcePresenter(Source source, View view) {
        super(view);
        this.mSource = source;
    }

    @Override
    public void start() {
        super.start();
        if (mSource != null)
            mSource.load(this);
    }

    @Override
    public void destroy() {
        super.destroy();
        mSource.dispose();
        mSource = null;
    }
}
