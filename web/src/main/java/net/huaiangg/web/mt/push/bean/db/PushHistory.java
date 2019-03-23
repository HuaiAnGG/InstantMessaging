package net.huaiangg.web.mt.push.bean.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Description: 消息推送历史记录
 * @Auther: huaian
 * @Date: 2019/3/23 15:17
 */
@Entity
@Table(name = "tb_push_history")
public class PushHistory {

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
     * 推送的具体实体
     * 存储的类型都是JSON格式
     * BLOB 是大字段类型
     */
    @Lob
    @Column(nullable = false, columnDefinition = "BLOB")
    private String entity;

    /**
     * 推送的实体类型
     */
    @Column(nullable = false)
    private int entityType;

    /**
     * 接收者
     * 接收者不允许为空
     * 一个接收者可以接受很多推送消息
     * FetchType.EAGER : 加载一条推送消息的时候之间加载用户信息
     */
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "receiverID")
    private User receiver;
    @Column(nullable = false, updatable = false, insertable = false)
    private String receiverID;

    /**
     * 发送者
     * 发送者允许为空，因为可能是系统消息
     * 一个发送者可以发送很多推送消息
     * FetchType.EAGER : 加载一条发送消息的时候之间加载用户信息
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "senderID")
    private User sender;
    @Column(updatable = false, insertable = false)
    private String senderID;

    /**
     * 接收者放前传台下的设备推送ID
     * 对应User.PushID 可以为null
     */
    @Column
    private String receiverPushID;

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
     * 消息送达的时间，可为空
     */
    @Column
    private LocalDateTime arrivalAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public int getEntityType() {
        return entityType;
    }

    public void setEntityType(int entityType) {
        this.entityType = entityType;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(String receiverID) {
        this.receiverID = receiverID;
    }

    public String getReceiverPushID() {
        return receiverPushID;
    }

    public void setReceiverPushID(String receiverPushID) {
        this.receiverPushID = receiverPushID;
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

    public LocalDateTime getArrivalAt() {
        return arrivalAt;
    }

    public void setArrivalAt(LocalDateTime arrivalAt) {
        this.arrivalAt = arrivalAt;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }
}