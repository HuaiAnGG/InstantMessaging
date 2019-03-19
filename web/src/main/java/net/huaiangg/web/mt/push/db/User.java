package net.huaiangg.web.mt.push.db;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @Description: User的model
 * @Auther: huaian
 * @Date: 2019/3/20 00:22
 */

@Entity
@Table(name = "tb_user")
public class User {

    /**
     * 主键
     * 主键生成存储类型为UUID
     * 把UUID的生成器定义为uuid2，uuid2是常规的UUID toString
     * 不允许更改，不允许为空
     */
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id;

    /**
     * 用户名必须唯一
     */
    @Column(nullable = false, length = 128, unique = true)
    private String name;

    /**
     * 电话必须唯一
     */
    @Column(nullable = false, length = 62, unique = true)
    private String phone;

    @Column(nullable = false)
    private String password;

    /**
     * 头像 允许为空
     */
    @Column
    private String portrait;

    /**
     * 描述 允许为空
     */
    @Column
    private String description;

    /**
     * 性别 不允许为空(有初始值)
     */
    @Column(nullable = false)
    private int sex = 0;

    /**
     * token 可以拉取用户信息，不允许重复
     */
    @Column(unique = true)
    private String token;

    /**
     * 用户推送唯一识别码
     */
    @Column
    private String pushID;

    /**
     * 创建时间戳，在创建的时候就已经写进去
     */
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDate createAt = LocalDate.now();

    /**
     * 最后一次收到消息的时间，
     */
    @Column
    private LocalDate lastReceivedAt = LocalDate.now();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPushID() {
        return pushID;
    }

    public void setPushID(String pushID) {
        this.pushID = pushID;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public LocalDate getLastReceivedAt() {
        return lastReceivedAt;
    }

    public void setLastReceivedAt(LocalDate lastReceivedAt) {
        this.lastReceivedAt = lastReceivedAt;
    }
}
