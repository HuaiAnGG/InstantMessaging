package org.huaiangg.mt.factory.data.helper;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.huaiangg.mt.factory.model.db.Session;
import org.huaiangg.mt.factory.model.db.Session_Table;

/**
 * @description: 会话辅助工具类
 * @author: HuaiAngg
 * @create: 2019-04-09 17:09
 */
public class SessionHelper {
    // 从本地查询Session
    public static Session findFromLocal(String id) {
        return SQLite.select()
                .from(Session.class)
                .where(Session_Table.id.eq(id))
                .querySingle();
    }
}
