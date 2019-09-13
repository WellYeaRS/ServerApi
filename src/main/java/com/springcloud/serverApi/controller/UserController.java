package com.springcloud.serverApi.controller;

import com.springcloud.serverApi.entity.User;
import com.springcloud.serverApi.service.UserService;
import com.springcloud.serverApi.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public Result login(@RequestParam(name="userName")String userName,
                        @RequestParam(name="password")String password,
                        HttpServletRequest request){
        Result<User> result = userService.login(userName,password);
        if(result.getData()==null){
            return Result.fail("用户名密码错误!");
        }
        request.getSession().setAttribute("user",result.getData().getUserId());
        return Result.success();
    }
    @PostMapping("/register")
    public Result register(User user){
        return userService.register(user);
    }
    @PostMapping("/update")
    public Result update(User user){
        return userService.update(user);
    }
}
