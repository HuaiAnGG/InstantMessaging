package net.huaiangg.web.mt.push.db;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @Description:
 * @Auther: huaian
 * @Date: 2019/3/22 10:35
 */
@Entity
@Table(name = "tb_group")
public class Group {
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
     * 群名称必须唯一
     */
    @Column(nullable = false, length = 128, unique = true)
    private String name;

    /**
     * 群描述 不允许为空
     */
    @Column(nullable = false)
    private String description;

    /**
     * 群头像
     */
    @Column(nullable = false)
    private String picture;

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
     * 群的创建者
     * optional：可以选为fasle 必须有一个创建者
     * fetch：加载方式FetchType.EAGER， 急加载
     * 意味着加载群信息的时候就必须加载owner的信息
     * cascade：联想级别为ALL，所有得更改（更新，删除等）都将进行关系更新
     */
    @ManyToOne(optional = false, fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "ownerID")
    private User owner;

    @Column(nullable = false, updatable = false, insertable = false)
    private String ownerID;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }
}
