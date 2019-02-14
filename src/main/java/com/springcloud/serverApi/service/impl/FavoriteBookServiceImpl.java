package com.springcloud.serverApi.service.impl;

import com.springcloud.serverApi.entity.FavoriteBook;
import com.springcloud.serverApi.repository.FavoriteBookRepository;
import com.springcloud.serverApi.service.FavoriteBookService;
import com.springcloud.serverApi.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteBookServiceImpl implements FavoriteBookService {
    @Autowired
    private FavoriteBookRepository favoriteBookRepository;
    /**
     * 点赞
     *
     * @param bookId
     * @param userId
     * @return
     */
    @Override
    public Result addFavoriteBook(long bookId, long userId) {
        FavoriteBook favoriteBook = new FavoriteBook();
        favoriteBook.setBookId(bookId);
        favoriteBook.setUserId(userId);
        favoriteBookRepository.save(favoriteBook);
        return Result.success();
    }

    /**
     * 取消点赞
     *
     * @param bookId
     * @param userId
     * @return
     */
    @Override
    public Result removeFavoriteBook(long bookId, long userId) {
        favoriteBookRepository.deleteByBookIdAndUserId(bookId,userId);
        return Result.success();
    }
}
