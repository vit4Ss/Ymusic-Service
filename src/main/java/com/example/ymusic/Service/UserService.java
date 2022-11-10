package com.example.ymusic.Service;

import com.example.ymusic.domain.User;

public interface UserService {
    int getUserByAccount(String account);
    int updateUser(User user);
}
