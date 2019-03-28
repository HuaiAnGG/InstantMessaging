package net.huaiangg.web.mt.push.service;

import net.huaiangg.web.mt.push.bean.api.base.ResponseModel;
import net.huaiangg.web.mt.push.bean.api.user.UpdateInfoModel;
import net.huaiangg.web.mt.push.bean.card.UserCard;
import net.huaiangg.web.mt.push.bean.db.User;
import net.huaiangg.web.mt.push.factory.UserFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @Description: 用户信息处理的Service
 * @Auther: huaian
 * @Date: 2019/3/24 14:12
 */
// 127.0.0.1/api/user/...
@Path("/user")
public class UserService extends BaseService {

    // 用户信息修改接口
    // 返回自己的个人信息
    @PUT
    //@Path("") //127.0.0.1/api/user 不需要写，就是当前目录
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<UserCard> update(UpdateInfoModel model) {
        if (!UpdateInfoModel.check(model)) {
            return ResponseModel.buildParameterError();
        }

        User self = getSelf();
        // 更新用户信息
        self = model.updateToUser(self);
        self = UserFactory.update(self);
        // 构架自己的用户信息
        UserCard card = new UserCard(self, true);
        // 返回
        return ResponseModel.buildOk(card);
    }

}
