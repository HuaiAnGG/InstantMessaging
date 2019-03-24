package org.huaiangg.mt.factory.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.raizlabs.android.dbflow.structure.ModelAdapter;

/**
 * @description: DBFlow的数据库过滤字段 Gson
 * @author: HuaiAngg
 * @create: 2019-03-24 16:34
 */
public class DBFlowExclusionStrategy implements ExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        // 被跳过的字段
        // 只要是属于DBFlow数据的
        return f.getDeclaredClass().equals(ModelAdapter.class);
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        // 别跳过的Class
        return false;
    }
}