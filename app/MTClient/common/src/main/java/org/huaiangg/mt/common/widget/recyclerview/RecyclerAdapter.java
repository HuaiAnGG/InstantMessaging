package org.huaiangg.mt.common.widget.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: HuaiAngg
 * @create: 2019-03-18 23:37
 */
public class RecyclerAdapter<Data> extends RecyclerView.Adapter {

    private final List<Data> mDataList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public static abstract class ViewHolder<Data> extends RecyclerView.ViewHolder {

        protected Data mData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bind(Data data) {
            this.mData = data;
        }

        protected abstract void onBind(Data data);
    }
}
