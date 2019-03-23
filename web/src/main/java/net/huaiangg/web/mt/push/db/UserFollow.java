package net.huaiangg.web.mt.push.db;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @Description: 用户间的关系
 *                  用于用户进行好友关系的实现
 * @Auther: huaian
 * @Date: 2019/3/20 01:36
 */
@Entity
@Table(name = "tb_user_follow")
public class UserFollow {

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
     * 定义发起人 你关注某人 这里就是你
     * 多对一：你可以很多人，每次关注就是一条记录
     * 你可以创建多个关注的信息，所以是多对一
     * 这里的多对一是 User 对应多个UserFollow
     * optional 不可选，必须储存，一条记录一定要有一个“你”
     */
    @ManyToOne(optional = false)
    // 定义关联表的字段名origin，对应的是User.id
    @JoinColumn(name = "origin")
    private User origin;

    // 把这个列抽取出来存到model中，不允许为空，不允许更新，不允许插入
    @Column(nullable = false, updatable = false, insertable = false)
    private String originID;

    /**
     * 定义关注的目标 你关注的人
     * 多对一：你可以很多人，每次关注就是一条记录
     * 你可以创建多个关注的信息，所以是多对一
     * 这里的多对一是 User 对应多个UserFollow
     * optional 不可选，必须储存，一条记录一定要有一个“你”
     */
    @ManyToOne(optional = false)
    // 定义关联表的字段名origin，对应的是User.id
    private User target;
    // 把这个列抽取出来存到model中，不允许为空，不允许更新，不允许插入
    @Column(nullable = false, updatable = false, insertable = false)
    private String targetID;

    // 别名,也是target的昵称
    private String alias;

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

    public User getOrigin() {
        return origin;
    }

    public void setOrigin(User origin) {
        this.origin = origin;
    }

    public String getOriginID() {
        return originID;
    }

    public void setOriginID(String originID) {
        this.originID = originID;
    }

    public User getTarget() {
        return target;
    }

    public void setTarget(User target) {
        this.target = target;
    }

    public String getTargetID() {
        return targetID;
    }

    public void setTargetID(String targetID) {
        this.targetID = targetID;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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
