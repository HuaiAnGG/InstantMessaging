package org.huaiangg.mt.common.widget.recyclerview;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.huaiangg.mt.common.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @description: RecyclerAdapter类
 * @author: HuaiAngg
 * @create: 2019-03-18 23:37
 */
public abstract class RecyclerAdapter<Data>
        extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder<Data>>
        implements View.OnClickListener, View.OnLongClickListener,
        AdapterCallback<Data> {

    private final List<Data> mDataList;
    // 监听器
    private AdapterListenter<Data> mListenter;

    /**
     * 构造函数模块
     */
    public RecyclerAdapter() {
        this(null);
    }

    public RecyclerAdapter(AdapterListenter<Data> listenter) {
        this(new ArrayList<Data>(), listenter);
    }

    public RecyclerAdapter(List<Data> dataList, AdapterListenter<Data> listenter) {
        this.mListenter = listenter;
        this.mDataList = dataList;
    }

    /**
     * 重写默认的布局类型返回
     *
     * @param position 坐标
     * @return 布局类型，XML布局文件的ID
     */
    @Override
    public int getItemViewType(int position) {
        return getItemViewType(position, mDataList.get(position));
    }

    /**
     * 得到的布局类型
     *
     * @param position 坐标
     * @param data     当前的数据
     * @return XML的ID, 用于创建ViewHolder
     */
    @LayoutRes
    protected abstract int getItemViewType(int position, Data data);

    /**
     * 创建一个Viewholder
     *
     * @param parent   RecyclerView
     * @param viewType 界面的类型,约定为XML布局的ID
     * @return ViewHolder
     */
    @NonNull
    @Override
    public ViewHolder<Data> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 得到LayoutInflater用于把XML初始化为View
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        // 把XML id为vieType的翁建初始化为一个 root View
        View root = inflater.inflate(viewType, parent, false);
        // 通过子类必须实现的方法，得到一个ViewHolder
        ViewHolder<Data> holder = onCreateViewHolder(root, viewType);

        //设置view的tag为id，进行双向绑定
        root.setTag(R.id.tag_recycler_holder);
        // 设置时间点击
        root.setOnClickListener(this);
        root.setOnLongClickListener(this);

        // 进行界面注解绑定
        holder.unbinder = ButterKnife.bind(root);
        // 绑定callback
        holder.callback = this;

        return holder;
    }

//    /**
//     * 点击事件
//     *
//     * @param v 视图的对象
//     */
//    @Override
//    public void onClick(View v) {
//        ViewHolder viewHolder = (ViewHolder) v.getTag(R.id.tag_recycler_holder);
//        if (this.mListenter != null) {
//            // 得到ViewHolder 当前对应的适配器中的坐标
//            int position = viewHolder.getAdapterPosition();
//            // 回调方法
//            this.mListenter.onItemClick(viewHolder, mDataList.get(position));
//        }
//    }
//
//    /**
//     * 长按点击事件
//     *
//     * @param v 视图的对象
//     * @return
//     */
//    @Override
//    public boolean onLongClick(View v) {
//        ViewHolder viewHolder = (ViewHolder) v.getTag(R.id.tag_recycler_holder);
//        if (this.mListenter != null) {
//            // 得到ViewHolder 当前对应的适配器中的坐标
//            int position = viewHolder.getAdapterPosition();
//            // 回调方法
//            this.mListenter.onItemLongClick(viewHolder, mDataList.get(position));
//            return true;
//        }
//        return false;
//    }

    /**
     * 设置适配器监听
     *
     * @param adapterListenter
     */
    public void setListenter(AdapterListenter<Data> adapterListenter) {
        this.mListenter = adapterListenter;
    }

    /**
     * 得到一个新的ViewHolder
     *
     * @param root     根布局
     * @param viewType 布局类型，其实就是XML的ID
     * @return Viewholder
     */
    protected abstract ViewHolder<Data> onCreateViewHolder(View root, int viewType);

    /**
     * 绑定数据到Holder上
     *
     * @param holder   ViewHolder
     * @param position 坐标
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder<Data> holder, int position) {
        // 得到绑定数据
        Data data = mDataList.get(position);
        // 出发holder的绑定方法
        holder.onBind(data);
    }

    /**
     * 得到当前集合的数据量
     *
     * @return 集合长度
     */
    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    /**
     * 插入一条数据并通知插入
     *
     * @param data 插入的数据
     */
    public void add(Data data) {
        mDataList.add(data);
        notifyItemInserted(mDataList.size() - 1);
    }

    /**
     * 插入一堆数据并通知插入
     *
     * @param datalist 数据列表
     */
    public void add(Data... datalist) {
        if (datalist != null && datalist.length > 0) {
            // 获取mDataLsit的长度
            int startPos = mDataList.size();
            // 把新增数据添加到吗DATaList中
            Collections.addAll(mDataList, datalist);
            // 更新数据列表
            notifyItemRangeChanged(startPos, datalist.length);
        }
    }

    /**
     * 插入一堆数据并通知插入
     *
     * @param datalist 数据列表
     */
    public void add(Collection<Data> datalist) {
        if (datalist != null && datalist.size() > 0) {
            // 获取mDataLsit的长度
            int startPos = mDataList.size();
            // 把新增数据添加到吗DATaList中
            mDataList.addAll(datalist);
            // 更新数据列表
            notifyItemRangeChanged(startPos, datalist.size());
        }
    }

    /**
     * 删除操作
     */
    public void clear() {
        mDataList.clear();
        notifyDataSetChanged();
    }

    /**
     * 替换一个新的集合，其中包括了清空数据操作
     *
     * @param dataList 数据集
     */
    public void replace(Collection<Data> dataList) {
        mDataList.clear();
        if (dataList == null || dataList.size() == 0)
            return;
        mDataList.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override
    public void update(Data data, ViewHolder<Data> holder) {
        // 得到当前ViewHolder的坐标
        int pos = holder.getAdapterPosition();
        if (pos >= 0) {
            // 进行数据的移除与更新
            mDataList.remove(pos);
            mDataList.add(pos, data);
            // 通知这个坐标下的数据有更新
            notifyItemChanged(pos);
        }
    }

    @Override
    public void onClick(View v) {
        ViewHolder viewHolder = (ViewHolder) v.getTag(R.id.tag_recycler_holder);
        if (this.mListenter != null) {
            // 得到ViewHolder当前对应的适配器中的坐标
            int pos = viewHolder.getAdapterPosition();
            // 回掉方法
            this.mListenter.onItemClick(viewHolder, mDataList.get(pos));
        }

    }

    @Override
    public boolean onLongClick(View v) {
        ViewHolder viewHolder = (ViewHolder) v.getTag(R.id.tag_recycler_holder);
        if (this.mListenter != null) {
            // 得到ViewHolder当前对应的适配器中的坐标
            int pos = viewHolder.getAdapterPosition();
            // 回掉方法
            this.mListenter.onItemLongClick(viewHolder, mDataList.get(pos));
            return true;
        }
        return false;
    }

    /**
     * 设置适配器的监听
     *
     * @param adapterListener AdapterListener
     */
    public void setListener(AdapterListenter<Data> adapterListener) {
        this.mListenter = adapterListener;
    }

    /**
     * 我们的自定义监听器
     *
     * @param <Data> 范型
     */
    public interface AdapterListenter<Data> {
        // 当Cell点击的时候触发
        void onItemClick(RecyclerAdapter.ViewHolder holder, Data data);

        // 当Cell长按时触发
        void onItemLongClick(RecyclerAdapter.ViewHolder holder, Data data);
    }

    /**
     * 自定义的ViewHolder
     *
     * @param <Data> 泛型类型
     */
    public static abstract class ViewHolder<Data> extends RecyclerView.ViewHolder {
        private Unbinder unbinder;
        private AdapterCallback<Data> callback;
        protected Data mData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        /**
         * 用于绑定数据的触发
         *
         * @param data 绑定的数据
         */
        void bind(Data data) {
            this.mData = data;
            onBind(mData);
        }

        /**
         * 当初发数据的时候必须复写
         *
         * @param data 绑定的数据
         */
        protected abstract void onBind(Data data);

        /**
         * Holder自动更新Data操作
         *
         * @param data Data数据
         */
        public void updateData(Data data) {
            if (this.callback != null) {
                this.callback.update(data, this);
            }
        }
    }

    /**
     * 对回调接口做一次实现AdapterListener
     *
     * @param <Data>
     */
    public static abstract class AdapterListenerImpl<Data> implements AdapterListenter<Data> {

        @Override
        public void onItemClick(ViewHolder holder, Data data) {

        }

        @Override
        public void onItemLongClick(ViewHolder holder, Data data) {

        }
    }
}
