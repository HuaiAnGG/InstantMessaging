package net.huaiangg.web.mt.push.bean.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Description: 群组成员表
 * @Auther: huaian
 * @Date: 2019/3/23 14:57
 */
@Entity
@Table(name = "tb_group_member")
public class GroupMember {

    // 默认不接受消息
    public static final int NOTIFY_LEVEL_INVALID = -1;
    // 默认通知级别
    public static final int NOTIFY_LEVEL_NONE = 0;
    // 接收消息不提醒
    public static final int NOTIFY_LEVEL_CLOSE = 1;

    // 默认权限
    public static final int PERMISSION_TYPE_NONE = 0;
    // 管理员权限
    public static final int PERMISSION_TYPE_ADMIN = 1;
    // 群主权限
    public static final int PERMISSION_TYPE_ADMIN_SU = 100;

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
     * 别名,也是target的昵称
     */
    private String alias;

    /**
     * 消息通知级别
     */
    @Column(nullable = false)
    private int notifyLevel = NOTIFY_LEVEL_NONE;

    /**
     * 成员的权限类型
     */
    @Column(nullable = false)
    private int  permissionType = PERMISSION_TYPE_ADMIN;

    /**
     * 定义为创建时间戳，在创建时就已经写入
     */
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    /**
     * 定义为更新时间戳，在创建时就已经写入
     */
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();

    /**
     * 成员信息对应的用户信息
     */
    @JoinColumn(name = "userID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;
    @Column(nullable = false, updatable = false, insertable = false)
    private String userID;

    /**
     * 成员信息对应的群聊信息
     */
    @JoinColumn(name = "groupID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Group group;
    @Column(nullable = false, updatable = false, insertable = false)
    private String groupId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getNotifyLevel() {
        return notifyLevel;
    }

    public void setNotifyLevel(int notifyLevel) {
        this.notifyLevel = notifyLevel;
    }

    public int getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(int permissionType) {
        this.permissionType = permissionType;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupID) {
        this.groupId = groupID;
    }
}
