package org.huaiangg.mt.common.widget.recyclerview;

import android.support.v7.widget.RecyclerView;

/**
 * @description: 自定义监听器
 * @author: HuaiAngg
 * @create: 2019-03-19 19:17
 */
public interface AdapterListenter<Data> {

    // 当Cell 点击的时候触发
    void onItemClick(RecyclerAdapter.ViewHolder holder, Data data);

    // 当cell 长按的触发
    void onItemLongClick(RecyclerAdapter.ViewHolder holder, Data data);

}
