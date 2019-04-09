package org.huaiangg.mt.factory.model.db;

import com.raizlabs.android.dbflow.structure.BaseModel;

import org.huaiangg.mt.factory.utils.DiffUiDataCallback;

/**
 * @description: 我们APP中的基础的一个BaseDbModel，
 *               基础了数据库框架DbFlow中的基础类
 *               同时定义类我们需要的方法
 *
 * @author: HuaiAngg
 * @create: 2019-04-09 15:51
 */
public abstract class BaseDbModel<Model> extends BaseModel
        implements DiffUiDataCallback.UiDataDiffer<Model> {
}
