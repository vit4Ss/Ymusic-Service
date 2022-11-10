package com.example.ymusic.Service.impl;

import com.example.ymusic.Service.UserService;
import com.example.ymusic.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static java.util.Collections.emptyList;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;


    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        User user = userService.getUserMsgByAccount(account);
        if(user == null){
            throw new UsernameNotFoundException(account);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), emptyList());
    }
}
