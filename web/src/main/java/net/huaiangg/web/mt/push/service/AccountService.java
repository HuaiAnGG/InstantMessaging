package net.huaiangg.web.mt.push.service;

import net.huaiangg.web.mt.push.bean.api.account.RegisterModel;

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

    @POST
    @Path("register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RegisterModel register(RegisterModel model){
        return model;
        /*System.out.println("已经进入register函数");
        User user = new User();
        user.setName("HuaianGG");
        user.setSex(2);
        return user;*/
    }
}
