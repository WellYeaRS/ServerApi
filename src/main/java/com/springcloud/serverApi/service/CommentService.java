package com.springcloud.serverApi.service;

import com.springcloud.serverApi.vo.PageInfo;
import com.springcloud.serverApi.vo.Result;

public interface CommentService {
    /**
     * 添加评论
     * @param bookId
     * @param userId
     * @param content
     * @return
     */
    Result addComment(long bookId,long userId,String content);

    /**
     * 获取评论
     * @param bookId
     * @param page
     * @param size
     * @return
     */
    PageInfo getComments(long bookId,int page,int size);
}
