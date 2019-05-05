package com.pancaker.pancake.domain;

import java.util.Date;

/**
 * Created by jianbinggouzi on 19-5-5.
 */

public class User extends BaseDomain {

    public static final int USER_LOCK = 1;

    public static final int USER_UNLOCK = 0;

    public static final int USER_NO_VIP = 1;

    public static final int USER_VIP = 2;

    public static final int USER_ADMIN = 3;

    private String userId;

    private String userName;

    private String password;

    private String userPhone;

    private long userType;

    private long locked;

    private long credit;

    private Date lastVisit;

    private String lastIp;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public long getUserType() {
        return userType;
    }

    public void setUserType(long userType) {
        this.userType = userType;
    }

    public long getLocked() {
        return locked;
    }

    public void setLocked(long locked) {
        this.locked = locked;
    }

    public long getCredit() {
        return credit;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public boolean equals(User user) {
        return userId.equals(user.getUserId()) && password.equals(user.getPassword());
    }

}

