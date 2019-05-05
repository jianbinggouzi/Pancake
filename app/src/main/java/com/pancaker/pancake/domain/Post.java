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
public class Post {
    @Id
    private String Id;
    @Transient
    private User user;
    @Property(nameInDb = "user_id")
    private String userId;
    @Property(nameInDb = "create_time")
    private Date createTime;
    @Property(nameInDb = "post_text")
    private String postText;
    @Transient
    private Post lastPost;
    @Property(nameInDb = "last_post_id")
    private String lastPostId;
    @Transient
    private User toUser;
    @Property(nameInDb = "to_user_id")
    private String toUserId;
    @Property(nameInDb = "digest")
    private int digest;

    @Generated(hash = 22678656)
    public Post(String Id, String userId, Date createTime, String postText,
            String lastPostId, String toUserId, int digest) {
        this.Id = Id;
        this.userId = userId;
        this.createTime = createTime;
        this.postText = postText;
        this.lastPostId = lastPostId;
        this.toUserId = toUserId;
        this.digest = digest;
    }

    @Generated(hash = 1782702645)
    public Post() {
    }

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getLastPostId(){
        return lastPostId;
    }

    public void setLastPostId(String lastPostId){
        this.lastPostId = lastPostId;
    }

    public String getToUserId(){
        return toUserId;
    }

    public void setToUserId(String toUserId){
        this.toUserId = toUserId;
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
