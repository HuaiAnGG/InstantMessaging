package org.huaiangg.mt.common.widget.recyclerview;

/**
 * @description: 适配器回调类
 * @author: HuaiAngg
 * @create: 2019-03-18 23:36
 */
public interface AdapterCallback<Data> {
    void update(Data data, RecyclerAdapter.ViewHolder<Data> holder);
}
