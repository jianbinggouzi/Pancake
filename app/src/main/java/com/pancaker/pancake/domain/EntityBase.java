package com.pancaker.pancake.domain;

import java.util.Date;

/**
 * Created by jianbinggouzi on 19-5-5.
 */

public class EntityBase extends BaseDomain {

    private String Id;

    private User user;

    private Date createTime;


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

