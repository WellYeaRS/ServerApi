package com.springcloud.serverApi.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@DynamicUpdate(true)
@DynamicInsert(true)
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private long bookId;
    @Column(name = "book_Name")
    private String bookName;

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public long getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }
}
