package com.pancaker.pancake.domain;

/**
 * Created by jianbinggouzi on 19-5-5.
 */

public class Post extends EntityBase {

    private String postText;

    private Post lastPost;

    private User toUser;

    private int digest;

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public Post getLastPost() {
        return lastPost;
    }

    public void setLastPost(Post lastPost) {
        this.lastPost = lastPost;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public int getDigest() {
        return digest;
    }

    public void setDigest(int digest) {
        this.digest = digest;
    }

}
