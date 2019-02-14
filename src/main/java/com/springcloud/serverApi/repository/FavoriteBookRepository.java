package com.springcloud.serverApi.repository;

import com.springcloud.serverApi.entity.FavoriteBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface FavoriteBookRepository extends JpaRepository<FavoriteBook,Long>{
    /**
     * 通过bookId和用户Id删除
     * @param bookId
     * @param userId
     */
    @Transactional
    void deleteByBookIdAndUserId(long bookId,long userId);
}
