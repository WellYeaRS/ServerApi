package com.springcloud.serverApi.service;

import com.springcloud.serverApi.vo.PageInfo;
import com.springcloud.serverApi.vo.Result;

import java.util.Date;

public interface BorrowService {
    /**
     * 借阅书籍
     * @param bookId
     * @param userId
     * @return
     */
    Result borrowBook(long bookId,long userId);

    /**
     * 查看借阅记录
     * @param bookId
     * @param page
     * @param size
     * @return
     */
    PageInfo getBorrowRecords(long bookId, int page, int size,
                              Integer state, Date begDate, Date endDate);
}
