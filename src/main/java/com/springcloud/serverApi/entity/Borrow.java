package com.springcloud.serverApi.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "borrows")
@DynamicUpdate(true)
@DynamicInsert(true)
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})
public class Borrow {
    @Id
    @GeneratedValue
    @Column(name = "borrow_Id")
    private long borrowId;
    @Column(name = "book_Id")
    private long bookId;
    @Column(name = "user_Id")
    private long userId;
    @Column(name = "lend_Time")
    private Date lendTime;
    @Column(name = "return_Time")
    private Date returnTime;
    @Column(name = "expire_Time")
    private Date expireTime;
    @Column(name = "state")
    private int state;
    @Transient
    private User borrowUser;
    @Transient
    private Book book;

    public User getBorrowUser() {
        return borrowUser;
    }

    public void setBorrowUser(User borrowUser) {
        this.borrowUser = borrowUser;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(long borrowId) {
        this.borrowId = borrowId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getLendTime() {
        return lendTime;
    }

    public void setLendTime(Date lendTime) {
        this.lendTime = lendTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
