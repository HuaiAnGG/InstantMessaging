package org.huaiangg.mt.factory.data.group;

import org.huaiangg.mt.factory.model.card.GroupCard;
import org.huaiangg.mt.factory.model.card.GroupMemberCard;

/**
 * @description: 群中心的接口定义
 * @author: HuaiAngg
 * @create: 2019-04-09 15:47
 */
public interface GroupCenter {
    // 群卡片的处理
    void dispatch(GroupCard... cards);

    // 群成员的处理
    void dispatch(GroupMemberCard... cards);
}