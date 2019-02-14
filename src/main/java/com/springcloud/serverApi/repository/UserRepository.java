package com.springcloud.serverApi.repository;


import com.springcloud.serverApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User getUserByUserName(String userName);
}
