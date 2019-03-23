package net.huaiangg.web.mt.push.service;

import net.huaiangg.web.mt.push.db.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @Description: 访问路径映射
 * @Auther: huaian
 * @Date: 2019/3/18 09:19
 */
@Path("/account")
public class AccountService {

    /**
     * 测试API接口
     * 地址：http://localhost:8080/Gradle___MTServer___MTServer_1_0_SNAPSHOT_war/api/account/login
     * 方式：GET
     * @return
     */
    @GET
    @Path("login")
    public String get(){
        System.out.println("已经进入get函数");
        return "You get the login.";
    }

    /**
     * 测试API接口
     * 地址：http://localhost:8080/Gradle___MTServer___MTServer_1_0_SNAPSHOT_war/api/account/getUser
     * 方式：POST
     * @Consumes 指定请求的相应体格式
     * @Produces 返回相应体的格式
     * @return
     */
    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(){
        System.out.println("已经进入getUser函数");
        User user = new User();
        user.setName("HuaiAnGG");
        user.setSex(0);
        return user;
    }
}
