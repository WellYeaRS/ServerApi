package com.springcloud.serverApi.controller;

import com.springcloud.serverApi.filters.UserFilter;
import com.springcloud.serverApi.repository.UserRepository;
import com.springcloud.serverApi.service.CommentService;
import com.springcloud.serverApi.vo.PageInfo;
import com.springcloud.serverApi.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/addComment")
    public Result addComment(@RequestParam(name = "bookCtrlNo")long bookId,
                             String content){
        //
        Long userId = UserFilter.getUserId();
        if(userId == null){
            return Result.fail("暂未登录！");
        }
        return commentService.addComment(bookId,userId,content);
    }
    @PostMapping(value = "/getComments")
    public PageInfo getComments(@RequestParam(name = "bookCtrlNo")long bookId,
                                @RequestParam(name = "page",defaultValue = "1")int page,
                                @RequestParam(name = "size",defaultValue = "10")int size){
        return commentService.getComments(bookId,page,size);
    }
}
