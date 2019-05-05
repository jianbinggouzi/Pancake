package com.pancaker.pancake.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;

import java.util.Date;
import java.util.Set;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jianbinggouzi on 19-5-5.
 */
@Entity
public class Dynamics {
    @Id
    private String Id;
    @Property(nameInDb = "user_id")
    private String userId;
    @Transient
    private User user;
    @Property(nameInDb = "create_time")
    private Date createTime;
    @Property(nameInDb = "title")
    private String dynamicsTitle;
    @Property(nameInDb = "views")
    private int views;
    @Property(nameInDb = "replies")
    private int replies;
    @Property(nameInDb = "digests")
    private int digests;
    @Transient
    private Post mainPost;
    @Property(nameInDb = "main_post_id")
    private String mainPostId;
    @Property(nameInDb = "collects")
    private int collects;
    @Transient
    private Set<Post> comments;


    @Generated(hash = 1362802084)
    public Dynamics(String Id, String userId, Date createTime, String dynamicsTitle,
            int views, int replies, int digests, String mainPostId, int collects) {
        this.Id = Id;
        this.userId = userId;
        this.createTime = createTime;
        this.dynamicsTitle = dynamicsTitle;
        this.views = views;
        this.replies = replies;
        this.digests = digests;
        this.mainPostId = mainPostId;
        this.collects = collects;
    }

    @Generated(hash = 1046716107)
    public Dynamics() {
    }


    public String getMainPosiId(){
        return mainPostId;
    }

    public void setMainPosiId(String mainPostId){
        this.mainPostId = mainPostId;
    }

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

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

    public int getCollects() {
        return collects;
    }

    public void setCollects(int collects) {
        this.collects = collects;
    }

    public Post getMainPost() {
        return mainPost;
    }

    public void setMainPost(Post mainPost) {
        this.mainPost = mainPost;
    }

    public String getDynamicsTitle() {
        return dynamicsTitle;
    }

    public void setDynamicsTitle(String dynamicsTitle) {
        this.dynamicsTitle = dynamicsTitle;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    public int getDigests() {
        return digests;
    }

    public void setDigests(int digests) {
        this.digests = digests;
    }

    public Set<Post> getComments() {
        return comments;
    }

    public void setComments(Set<Post> comments) {
        this.comments = comments;
    }

    public String getMainPostId() {
        return this.mainPostId;
    }

    public void setMainPostId(String mainPostId) {
        this.mainPostId = mainPostId;
    }

}

