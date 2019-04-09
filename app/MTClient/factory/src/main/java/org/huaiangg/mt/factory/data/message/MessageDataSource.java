package org.huaiangg.mt.factory.data.message;

import org.huaiangg.mt.factory.data.DbDataSource;
import org.huaiangg.mt.factory.model.db.Message;

/**
 * @description: 消息的数据源定义，他的实现是：MessageRepository, MessageGroupRepository
 *              关注的对象是Message表
 * @author: HuaiAngg
 * @create: 2019-04-09 17:12
 */
public interface MessageDataSource extends DbDataSource<Message> {
}

