package com.pancaker.pancake.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jianbinggouzi on 19-5-5.
 */
@Entity
public class OperateLog extends BaseDomain {
    @Id
    private String operateLogId;
    @Property(nameInDb = "entity_id")
    private String entityId;
    @Transient
    private User sender;
    @Property(nameInDb = "sender_id")
    private String senderId;
    @Transient
    private User receiver;
    @Property(nameInDb = "receiver_id")
    private String receiverId;
    @Property(nameInDb = "operate_type")
    private int operateType;
    @Property(nameInDb = "time")
    private Date time;
    @Property(nameInDb = "entity_type")
    private int entityType;
    @Property(nameInDb = "text")
    private String text;

    @Generated(hash = 1437220499)
    public OperateLog(String operateLogId, String entityId, String senderId,
            String receiverId, int operateType, Date time, int entityType,
            String text) {
        this.operateLogId = operateLogId;
        this.entityId = entityId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.operateType = operateType;
        this.time = time;
        this.entityType = entityType;
        this.text = text;
    }

    @Generated(hash = 712536711)
    public OperateLog() {
    }

    public String getSenderId(){
        return senderId;
    }

    public void setSenderId(String senderId){
        this.senderId = senderId;
    }

    public String getReceiverId(){
        return receiverId;
    }

    public void setReceiverId(String receiverId){
        this.receiverId = receiverId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOperateLogId() {
        return operateLogId;
    }

    public void setOperateLogId(String operateLogId) {
        this.operateLogId = operateLogId;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public int getOperateType() {
        return operateType;
    }

    public void setOperateType(int operateType) {
        this.operateType = operateType;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getEntityType() {
        return entityType;
    }

    public void setEntityType(int entityType) {
        this.entityType = entityType;
    }

}

