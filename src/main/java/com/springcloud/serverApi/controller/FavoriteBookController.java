package com.springcloud.serverApi.controller;

import com.springcloud.serverApi.entity.User;
import com.springcloud.serverApi.filters.UserFilter;
import com.springcloud.serverApi.service.FavoriteBookService;
import com.springcloud.serverApi.service.UserService;
import com.springcloud.serverApi.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 书本点赞和取消点赞接口
 */
@RestController
@RequestMapping("/favoriteBook")
public class FavoriteBookController {
    @Autowired
    private FavoriteBookService favoriteBookService;

    @PostMapping("/addFavoriteBook")
    public Result addFavoriteBook(@RequestParam(name="bookId")long bookId){
        Long userId = UserFilter.getUserId();
        if(userId == null){
            return Result.fail("暂未登录！");
        }
        return favoriteBookService.addFavoriteBook(bookId,userId);
    }
    @PostMapping("/removeFavoriteBook")
    public Result removeFavoriteBook(@RequestParam(name="bookId")long bookId){
        Long userId = UserFilter.getUserId();
        if(userId == null){
            return Result.fail("暂未登录！");
        }
        return favoriteBookService.removeFavoriteBook(bookId,userId);
    }

}
