package com.springcloud.serverApi.service;

import com.springcloud.serverApi.vo.Result;

public interface FavoriteBookService {
    /**
     * 点赞
     * @param bookId
     * @param userId
     * @return
     */
    Result addFavoriteBook(long bookId,long userId);
    /**
     * 取消点赞
     * @param bookId
     * @param userId
     * @return
     */
    Result removeFavoriteBook(long bookId,long userId);
}
