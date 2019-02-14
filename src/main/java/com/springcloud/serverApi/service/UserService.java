package com.springcloud.serverApi.service;

import com.springcloud.serverApi.entity.User;
import com.springcloud.serverApi.vo.Result;

public interface UserService {
    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    Result login(String userName,String password);

    /**
     * 注册
     * @param user
     * @return
     */
    Result register(User user);

    /**
     * 修改
     * @param user
     * @return
     */
    Result update(User user);
}
