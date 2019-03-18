package net.huaiangg.web.mt.push.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @Description: 访问路径映射
 * @Auther: huaian
 * @Date: 2019/3/18 09:19
 */
@Path("/account")
public class AccountService {

    /**
     * 测试API接口
     * 地址：localhost:8080/api/account/login
     * @return
     */
    @GET
    @Path("login")
    public String get(){
        System.out.println("已经进入get函数");
        return "You get the login.";
    }
}
