package org.huaiangg.mt.factory.model.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * @description: 数据库基本信息
 * @author: HuaiAngg
 * @create: 2019-03-24 16:03
 */
@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase {
    public static final String NAME = "AppDatabase";
    public static final int VERSION = 2;
}