package com.example.ymusic.Service.impl;


import cn.hutool.core.date.DateUtil;
import com.example.ymusic.Mapper.UserMapper;
import com.example.ymusic.Service.UserService;
import com.example.ymusic.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {

    final
    UserMapper userMapper;

    public UserImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUserMsgByAccount(String account) {
        return userMapper.getUserMsgByAccount(account);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public int getUserByAccount(String account) {
        return userMapper.getUserBYAccount(account);
    }

    public int singUp(User user) {
        //user.setCreateTime(System.currentTimeMillis());
        user.setCreateTime(DateUtil.date(System.currentTimeMillis()));
        return userMapper.singUp(user);
    }
}
