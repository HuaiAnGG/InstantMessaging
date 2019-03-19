package org.huaiangg.mt.mtclient;

/**
 * @description:
 * @author: HuaiAngg
 * @create: 2019-03-19 20:29
 */
public class UserService implements IUserService{

    @Override
    public String search(int hashCode) {
        return "User:" + hashCode;
    }
}
