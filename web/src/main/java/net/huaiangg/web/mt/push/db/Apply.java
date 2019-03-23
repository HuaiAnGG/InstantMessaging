package net.huaiangg.web.mt.push.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Description: 申请记录表
 * @Auther: huaian
 * @Date: 2019/3/23 16:00
 */
@Entity
@Table(name = "tb_apply")
public class Apply {
    // 添加好友
    public static final int TYPE_ADD_USER = 1;
    // 加入群
    public static final int TYPE_ADD_GROUP = 2;

    /**
     * 主键
     * 主键生成存储类型为UUID,自动生成uuid
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
     * 描述部分，对我们的申请信息做描述
     * eg: 我想加你为好友！！
     */
    @Column(nullable = false)
    private String description;

    /**
     * 申请人 可为空 为系统信息
     * 一个人可以有很多个申请
     */
    @ManyToOne
    @JoinColumn(name = "applicantID")
    private User applicant;
    @Column(updatable = false, insertable = false)
    private String applicantID;

    /**
     * 附件 可为空
     * 可以附带图片地址，或者其他
     */
    @Column(columnDefinition = "TEXT")
    private String attach;

    /**
     * 目标Id 不进行强关联，不建立主外键关系
     * type->TYPE_ADD_USER：User.id
     * type->TYPE_ADD_GROUP：Group.id
     */
    @Column(nullable = false)
    private String targetID;

    /**
     * 当前的申请类型
     */
    @Column(nullable = false)
    private int type;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getApplicant() {
        return applicant;
    }

    public void setApplicant(User applicant) {
        this.applicant = applicant;
    }

    public String getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(String applicantID) {
        this.applicantID = applicantID;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getTargetID() {
        return targetID;
    }

    public void setTargetID(String targetID) {
        this.targetID = targetID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
