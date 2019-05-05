package com.pancaker.pancake.domain;

import java.util.Set;

/**
 * Created by jianbinggouzi on 19-5-5.
 */

public class Dynamics extends EntityBase {

   private String dynamicsTitle;

    private int views;

    private int replies;

    private int digests;

    private Post mainPost;

    private int collects;

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

