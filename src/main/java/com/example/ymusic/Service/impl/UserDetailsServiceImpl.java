package com.example.ymusic.Service.impl;

import com.example.ymusic.Mapper.UserMapper;
import com.example.ymusic.Service.UserService;
import com.example.ymusic.domain.LoginUser;
import com.example.ymusic.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static java.util.Collections.emptyList;

/**
 * @author diyi
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        User user = userMapper.getUserMsgByAccount(account);
        log.info("账号{} 密码{}",user.getAccount(),user.getPassword());
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        return new LoginUser(user);
    }
}
