package net.huaiangg.web.mt.push;

import net.huaiangg.web.mt.push.service.AccountService;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.logging.Logger;

/**
 * @Description:
 * @Auther: huaian
 * @Date: 2019/3/18 09:06
 */
public class Application extends ResourceConfig {

    public Application() {
        // 注册逻辑处理包名
        //packages("net.huaiangg.web.mt.push.service");
        packages(AccountService.class.getPackage().getName());
        // 注册JSON解析器
        register(JacksonJsonProvider.class);
        // 注册日志打印输出
        register(Logger.class);
    }
}
