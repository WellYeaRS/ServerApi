package com.springcloud.serverApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
@DynamicUpdate(true)
@DynamicInsert(true)
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long userId;
    @Column(name = "user_Name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "school")
    private String school;
    @Column(name = "image")
    private String image;

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getSchool() {
        return school;
    }

    public String getImage() {
        return image;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
