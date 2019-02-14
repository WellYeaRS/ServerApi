package com.springcloud.serverApi.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "comments")
@DynamicUpdate(true)
@DynamicInsert(true)
public class Comment {
    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private long commentId;
    @Column(name = "user_Id")
    private long userId;
    @Column(name = "book_Id")
    private long bookId;
    @Column(name = "comment")
    private String comment;
    @Column(name = "updateTime")
    private Date updateTime;
    @Column(name = "likes")
    private long likes;

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public long getCommentId() {
        return commentId;
    }

    public long getUserId() {
        return userId;
    }

    public String getComment() {
        return comment;
    }

    public Date getUpdateTime() {
        return updateTime;
    }
}

