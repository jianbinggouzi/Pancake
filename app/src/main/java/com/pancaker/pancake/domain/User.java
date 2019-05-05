package com.pancaker.pancake.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.util.Date;

import static android.R.attr.id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jianbinggouzi on 19-5-5.
 */

@Entity
public class User extends BaseDomain {

    public static final int USER_LOCK = 1;

    public static final int USER_UNLOCK = 0;

    public static final int USER_NO_VIP = 1;

    public static final int USER_VIP = 2;

    public static final int USER_ADMIN = 3;
    @Id
    private String userId;
    @Property(nameInDb = "user_name")
    private String userName;
    @Property(nameInDb = "password")
    private String password;
    @Property(nameInDb = "user_phone")
    private String userPhone;
    @Property(nameInDb = "userType")
    private long userType;
    @Property(nameInDb = "locked")
    private long locked;
    @Property(nameInDb = "credit")
    private long credit;
    @Property(nameInDb = "last_visit")
    private Date lastVisit;
    @Property(nameInDb = "last_ip")
    private String lastIp;

    @Generated(hash = 810231845)
    public User(String userId, String userName, String password, String userPhone,
            long userType, long locked, long credit, Date lastVisit, String lastIp) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userPhone = userPhone;
        this.userType = userType;
        this.locked = locked;
        this.credit = credit;
        this.lastVisit = lastVisit;
        this.lastIp = lastIp;
    }

    @Generated(hash = 586692638)
    public User() {
    }

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

