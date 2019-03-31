package net.huaiangg.web.mt.push;

import net.huaiangg.web.mt.push.provider.AuthRequestFilter;
import net.huaiangg.web.mt.push.provider.GsonProvider;
import net.huaiangg.web.mt.push.service.AccountService;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.logging.Logger;

/**
 * @Description: 全局通用唯一Application
 * @Auther: huaian
 * @Date: 2019/3/18 09:06
 */
public class Application extends ResourceConfig {

    public Application() {
        // 注册逻辑处理包名
        //packages("net.huaiangg.web.mt.push.service");
        packages(AccountService.class.getPackage().getName());

        // 注册我们的全局请求拦截器
        register(AuthRequestFilter.class);

        // 注册JSON解析器
//        register(JacksonJsonProvider.class);

        // 替换系统解释器为GSON
        register(GsonProvider.class);

        // 注册日志打印输出
        register(Logger.class);
    }
}
