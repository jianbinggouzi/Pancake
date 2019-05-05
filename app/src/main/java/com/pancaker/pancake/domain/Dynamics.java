package com.pancaker.pancake.domain;

import java.util.Date;
import java.util.Set;

/**
 * Created by jianbinggouzi on 19-5-5.
 */

public class Dynamics {

    private String Id;

    private User user;

    private Date createTime;

    private String dynamicsTitle;

    private int views;

    private int replies;

    private int digests;

    private Post mainPost;

    private int collects;

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

    private Set<Post> comments;

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

}

