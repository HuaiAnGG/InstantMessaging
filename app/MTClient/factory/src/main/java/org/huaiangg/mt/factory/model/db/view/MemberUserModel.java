package org.huaiangg.mt.factory.model.db.view;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.QueryModel;

import org.huaiangg.mt.factory.model.db.AppDatabase;

/**
 * @description: 群成员对应的用户的简单信息表
 * @author: HuaiAngg
 * @create: 2019-04-09 15:57
 */
@QueryModel(database = AppDatabase.class)
public class MemberUserModel {
    @Column
    public String userId; // User-id/Member-userId
    @Column
    public String name; // User-name
    @Column
    public String alias; // Member-alias
    @Column
    public String portrait; // User-portrait
}