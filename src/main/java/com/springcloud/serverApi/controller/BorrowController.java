package com.springcloud.serverApi.controller;

import com.springcloud.serverApi.filters.UserFilter;
import com.springcloud.serverApi.service.BorrowService;
import com.springcloud.serverApi.vo.PageInfo;
import com.springcloud.serverApi.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;
    /**
     * 借阅书籍
     * @param bookId
     * @return
     */
    @PostMapping("/borrowBook")
    public Result borrowBook(@RequestParam(name = "bookCtrlNo")long bookId){
        Long userId = UserFilter.getUserId();
        if(userId == null){
            return Result.fail("暂未登录！");
        }
        return borrowService.borrowBook(bookId,userId);
    }

    /**
     * 查看借阅记录
     * @param bookId
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/getBorrowRecords")
    public PageInfo getBorrowRecords(@RequestParam(name = "bookCtrlNo")long bookId,
                                     @RequestParam(name = "page",defaultValue = "1")int page,
                                     @RequestParam(name = "size",defaultValue = "10")int size,
                                     Integer state, Date begDate, Date endDate){
        return borrowService.getBorrowRecords(bookId,page,size,state,begDate,endDate);
    }
}
