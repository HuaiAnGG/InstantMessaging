package org.huaiangg.mt.factory.data.user;

import org.huaiangg.mt.factory.model.card.UserCard;

/**
 * @description: 用户中心的基本定义
 * @author: HuaiAngg
 * @create: 2019-04-09 17:19
 */
public interface UserCenter {
    // 分发处理一堆用户卡片的信息，并更新到数据库
    void dispatch(UserCard... cards);
}
