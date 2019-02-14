package com.springcloud.serverApi.service.impl;

import com.springcloud.serverApi.entity.User;
import com.springcloud.serverApi.repository.UserRepository;
import com.springcloud.serverApi.service.UserService;
import com.springcloud.serverApi.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    /**
     * 登录
     *
     * @param userName
     * @param password
     * @return
     */
    @Override
    public Result login(String userName, String password) {
        //1.从数据库查询
        User user = userRepository.getUserByUserName(userName);
        if(user == null){
            return Result.fail("用户不存在！");
        }
        if(user.getPassword().equals(password)){
            Result success = Result.success();
            success.setData(user);
            return success;
        }
        return Result.fail("密码错误！");
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public Result register(User user) {
        userRepository.save(user);
        return Result.success();
    }

    /**
     * 修改
     *
     * @param user
     * @return
     */
    @Override
    public Result update(User user) {
        //根据用户id回去用户
        User dbUser = userRepository.getOne(user.getUserId());
        BeanUtils.copyProperties(user,dbUser);
        return Result.success();
    }
}

