package com.example.ymusic.Service;

import com.example.ymusic.domain.User;

public interface UserService {
    User getUserMsgByAccount(String account);
    int updateUser(User user);
    int getUserByAccount(String account);
    void userLogin(User user);
    //int singUp(User user);
}
