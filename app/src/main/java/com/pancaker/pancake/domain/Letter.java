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
public class Letter {
    @Id
    private String Id;
    @Transient
    private User user;
    @Property(nameInDb = "user_id")
    private String userId;
    @Property(nameInDb = "create_time")
    private Date createTime;
    @Property(nameInDb = "board_id")
    private String boardId;
    @Property(nameInDb = "title")
    private String letterTitle;
    @Property(nameInDb = "views")
    private int views;
    @Property(nameInDb = "replies")
    private int letterReplies;
    @Property(nameInDb = "shares")
    private int letterShares;
    @Property(nameInDb = "digests")
    private int digests;
    @Property(nameInDb = "collects")
    private int collects;
    @Transient
    private Post mainPost;
    @Property(nameInDb = "main_post_id")
    private String mainPostId;
    @Property(nameInDb = "thanks")
    private int thanks;
    @Transient
    private Set<Post> comments;
    @Property(nameInDb = "type")
    private int letterType;

    @Generated(hash = 468538437)
    public Letter(String Id, String userId, Date createTime, String boardId,
            String letterTitle, int views, int letterReplies, int letterShares,
            int digests, int collects, String mainPostId, int thanks,
            int letterType) {
        this.Id = Id;
        this.userId = userId;
        this.createTime = createTime;
        this.boardId = boardId;
        this.letterTitle = letterTitle;
        this.views = views;
        this.letterReplies = letterReplies;
        this.letterShares = letterShares;
        this.digests = digests;
        this.collects = collects;
        this.mainPostId = mainPostId;
        this.thanks = thanks;
        this.letterType = letterType;
    }

    @Generated(hash = 174375807)
    public Letter() {
    }

    public String getMainPostId(){
        return mainPostId;
    }

    public void setMainPostId(String mainPostId){
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

    public int getLetterType() {
        return this.letterType;
    }

}
