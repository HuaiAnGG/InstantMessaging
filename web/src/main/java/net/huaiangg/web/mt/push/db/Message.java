package net.huaiangg.web.mt.push.db;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @Description:
 * @Auther: huaian
 * @Date: 2019/3/22 10:15
 */
@Entity
@Table(name = "tb_message")
public class Message {

    // 字符串类型
    public static final int TYPE_STR = 1;
    // 图片类型
    public static final int TYPE_PIC = 2;
    // 文件类型
    public static final int TYPE_FILE = 3;
    // 语音类型
    public static final int TYPE_AUDIO = 4;
    /**
     * 主键
     * ID是由代码生成，由客户端生成
     * 不允许更改，不允许为空
     */
    @Id
    @PrimaryKeyJoinColumn
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id;

    /**
     * 内容不允许为空，内容为空
     */
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    /**
     *
     */
    private String attach;

    /**
     * 消息类型
     */
    private int type;

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

    /**
     * 发送者 不为空
     * 多个消息对应一个发送者
     * 这个字段仅仅是为了对应sender数据库字段的senderID
     * 不允许手动的更新或者插入
     */
    @JoinColumn(name = "senderID")
    @ManyToOne(optional = false)
    private User sender;
    @Column(nullable = false, updatable = false, insertable = false)
    private String senderID;

    /**
     * 接收者 可为空
     * 多个消息对应一个接收者
     */
    @JoinColumn(name = "receiverID")
    @ManyToOne
    private User receiver;
    @Column(updatable = false, insertable = false)
    private String receiverID;

    /**
     * 一个群可以接收多个消息
     */
    @JoinColumn(name = "groupID")
    @ManyToOne
    private Group group;
    @Column(updatable = false, insertable = false)
    private String groupID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }
}
