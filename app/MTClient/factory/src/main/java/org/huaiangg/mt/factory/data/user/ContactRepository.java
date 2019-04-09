package org.huaiangg.mt.factory.data.user;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.huaiangg.mt.factory.data.BaseDbRepository;
import org.huaiangg.mt.factory.data.DataSource;
import org.huaiangg.mt.factory.model.db.User;
import org.huaiangg.mt.factory.model.db.User_Table;
import org.huaiangg.mt.factory.persistence.Account;

import java.util.List;

/**
 * @description: 联系人仓库
 * @author: HuaiAngg
 * @create: 2019-04-09 17:18
 */
public class ContactRepository extends BaseDbRepository<User> implements ContactDataSource {
    @Override
    public void load(DataSource.SucceedCallback<List<User>> callback) {
        super.load(callback);

        // 加载本地数据库数据
        SQLite.select()
                .from(User.class)
                .where(User_Table.isFollow.eq(true))
                .and(User_Table.id.notEq(Account.getUserId()))
                .orderBy(User_Table.name, true)
                .limit(100)
                .async()
                .queryListResultCallback(this)
                .execute();
    }

    @Override
    protected boolean isRequired(User user) {
        return user.isFollow() && !user.getId().equals(Account.getUserId());
    }
}
