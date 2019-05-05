package com.pancaker.pancake.domain;

import java.util.Date;

/**
 * Created by jianbinggouzi on 19-5-5.
 */

public class OperateLog extends BaseDomain {

    private String operateLogId;

    private String entityId;

    private User sender;

    private User receiver;

    private int operateType;

    private Date time;

    private int entityType;

    private String text;

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

