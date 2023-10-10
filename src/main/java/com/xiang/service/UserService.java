package com.xiang.service;

import com.xiang.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiang.utils.Result;

/**
* @author chenwentao
* @description 针对表【news_user】的数据库操作Service
* @createDate 2023-10-10 20:37:33
*/
public interface UserService extends IService<User> {

    Result login(User user);

    Result getUserInfo(String token);
}
