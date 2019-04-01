package org.huaiangg.mt.mtclient.frags.search;


import org.huaiangg.mt.common.app.Fragment;
import org.huaiangg.mt.mtclient.R;
import org.huaiangg.mt.mtclient.activities.SearchActivity;

/**
 * 搜索群的界面实现
 */
public class SearchGroupFragment extends Fragment
        implements SearchActivity.SearchFragment {


    public SearchGroupFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_search_group;
    }

    @Override
    public void search(String content) {

    }
}
