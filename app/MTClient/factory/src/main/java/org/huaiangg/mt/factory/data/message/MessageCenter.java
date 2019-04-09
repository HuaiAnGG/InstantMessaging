package org.huaiangg.mt.factory.data.message;

import org.huaiangg.mt.factory.model.card.MessageCard;

/**
 * @description: 消息中心，进行消息卡片的消费
 * @author: HuaiAngg
 * @create: 2019-04-09 17:12
 */
public interface MessageCenter {
    void dispatch(MessageCard... cards);
}
