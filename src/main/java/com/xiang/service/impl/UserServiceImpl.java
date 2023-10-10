package com.xiang.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiang.pojo.User;
import com.xiang.service.UserService;
import com.xiang.mapper.UserMapper;
import com.xiang.utils.JwtHelper;
import com.xiang.utils.MD5Util;
import com.xiang.utils.Result;
import com.xiang.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
* @author chenwentao
* @description 针对表【news_user】的数据库操作Service实现
* @createDate 2023-10-10 20:37:33
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtHelper jwtHelper;
    @Override
    public Result login(User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername,user.getUsername());
        User loginUser = userMapper.selectOne(lambdaQueryWrapper);

        if (loginUser == null) {
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }

        if (!StringUtils.isEmpty(user.getUserPwd()) && MD5Util.encrypt(user.getUserPwd()).equals(loginUser.getUserPwd())) {
            String token = jwtHelper.createToken(Long.valueOf(loginUser.getUid()));
            Map data = new HashMap();
            data.put("token",token);
            return Result.ok(data);
        }

        return Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
    }

    @Override
    public Result getUserInfo(String token) {
        boolean expiration = jwtHelper.isExpiration(token);

    }
}




