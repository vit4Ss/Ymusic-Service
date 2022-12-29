package com.example.ymusic.Service.impl;


import cn.hutool.core.date.DateUtil;
import com.example.ymusic.Mapper.UserMapper;
import com.example.ymusic.Service.UserService;
import com.example.ymusic.domain.User;
import com.example.ymusic.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserImpl implements UserService {

    final
    UserMapper userMapper;
    @Autowired
    DateUtils dateUtils;

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

    @Override
    public int getUserByAccount(String account) {
        return userMapper.getUserBYAccount(account);
    }


    //登录信息更新
    @Override
    public void userLogin(User user) {
        if(user.getCreateTime() == null || user.getCreateTime().equals("")){
            user.setCreateTime(dateUtils.DateFormatsTime());
        }
            user.setLastUpdateTime(dateUtils.DateFormatsTime());
            log.info("User {}",user);
            userMapper.userLogin(user);
            //System.out.println(userMapper.userLogin(user));
    }
}
