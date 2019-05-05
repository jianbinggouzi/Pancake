package com.pancaker.pancake.domain;

import java.util.Date;
import java.util.Set;

/**
 * Created by jianbinggouzi on 19-5-5.
 */

public class Letter {

    private String Id;

    private User user;

    private Date createTime;

    private String boardId;

    private String letterTitle;

    private int views;

    private int letterReplies;

    private int letterShares;

    private int digests;

    private int collects;

    private Post mainPost;

    private int thanks;

    private Set<Post> comments;

    private int letterType;

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

    public int getThanks() {
        return thanks;
    }

    public void setThanks(int thanks) {
        this.thanks = thanks;
    }

    public int getLetteType() {
        return letterType;
    }

    public void setLetterType(int letterType) {
        this.letterType = letterType;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getBoardId() {
        return this.boardId;
    }

    public void setLetterTitle(String letterTitle) {
        this.letterTitle = letterTitle;
    }

    public String getLetterTitle() {
        return letterTitle;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getViews() {
        return views;
    }

    public void setLetterReplies(int letterReplies) {
        this.letterReplies = letterReplies;
    }

    public int getLetterReplies() {
        return letterReplies;
    }

    public void setLetterShares(int letterShares) {
        this.letterShares = letterShares;
    }

    public int getLetterShares() {
        return letterShares;
    }

    public int getCollects() {
        return collects;
    }

    public void setCollects(int collects) {
        this.collects = collects;
    }

    public int getDigests() {
        return digests;
    }

    public void setDigests(int digests) {
        this.digests = digests;
    }

    public void setMainPost(Post mainPost) {
        this.mainPost = mainPost;
    }

    public Post getMainPost() {
        return mainPost;
    }

    public void setComments(Set<Post> comments) {
        this.comments = comments;
    }

    public Set<Post> getComments() {
        return comments;
    }

}
