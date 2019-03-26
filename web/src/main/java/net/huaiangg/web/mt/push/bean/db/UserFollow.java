package net.huaiangg.web.mt.push.bean.db;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    // 定义关联表的字段名originId，对应的是User.id
    @JoinColumn(name = "originId")
    private User origin;

    // 把这个列抽取出来存到model中，不允许为空，不允许更新，不允许插入
    @Column(nullable = false, updatable = false, insertable = false)
    private String originId;

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
    private String targetId;

    // 别名,也是target的昵称
    private String alias;

    /**
     * 创建时间戳，在创建的时候就已经写进去
     */
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    /**
     * 定义为更新时间戳，在创建时就已经写入
     */
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();

    /**
     * 消息送达的时间
     */
    @Column
    private LocalDateTime receiveAt = LocalDateTime.now();


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

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originID) {
        this.originId = originID;
    }

    public User getTarget() {
        return target;
    }

    public void setTarget(User target) {
        this.target = target;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetID) {
        this.targetId = targetID;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
