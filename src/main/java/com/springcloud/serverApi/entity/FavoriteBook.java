package com.springcloud.serverApi.entity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "favorite_books")
@DynamicUpdate(true)
@DynamicInsert(true)
public class FavoriteBook {
    @Id
    @GeneratedValue
    @Column(name = "favorite_Id")
    private long favoriteId;
    @Column(name = "book_Id")
    private long bookId;
    @Column(name = "user_Id")
    private long userId;

    public long getFavoriteId() {
        return favoriteId;
    }

    public long getBookId() {
        return bookId;
    }

    public long getUserId() {
        return userId;
    }

    public void setFavoriteId(long favoriteId) {
        this.favoriteId = favoriteId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
