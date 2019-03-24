package org.huaiangg.mt.factory.model.api.user;

/**
 * @description:
 * @author: HuaiAngg
 * @create: 2019-03-24 16:07
 */
public class UserUpdateModel {
    private String name;
    private String portrait;
    private String desc;
    private int sex;

    public UserUpdateModel(String name, String portrait, String desc, int sex) {
        this.name = name;
        this.portrait = portrait;
        this.desc = desc;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserUpdateModel{" +
                "name='" + name + '\'' +
                ", portrait='" + portrait + '\'' +
                ", desc='" + desc + '\'' +
                ", sex=" + sex +
                '}';
    }
}
