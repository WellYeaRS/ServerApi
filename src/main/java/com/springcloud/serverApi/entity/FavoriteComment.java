package com.springcloud.serverApi.entity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;

//@Entity
//@Table(name = "favorite_comments")
//@DynamicUpdate(true)
//@DynamicInsert(true)
public class FavoriteComment {
    private long favoriteId;
    private long commentId;
    private long userId;

    public long getFavoriteId() {
        return favoriteId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public long getCommentId() {
        return commentId;
    }

    public long getUserId() {
        return userId;
    }

    public void setFavoriteId(long favoriteId) {
        this.favoriteId = favoriteId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
