package com.springcloud.serverApi.vo;


import com.springcloud.serverApi.entity.Book;
import com.springcloud.serverApi.entity.User;

import java.util.Date;

public class CommentVo {
    private long commentId;
    private String comment;
    private Date updateTime;
    private User commentUser;
    private Book book;
    public User getCommentUser() {
        return commentUser;
    }
    public void setCommentUser(User commentUser) {
        this.commentUser = commentUser;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }


    public void setCommentId(long commentId) {
        this.commentId = commentId;
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

    public String getComment() {
        return comment;
    }

    public Date getUpdateTime() {
        return updateTime;
    }
}

