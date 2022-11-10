package com.example.ymusic.Mapper;

import com.example.ymusic.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int getUserBYAccount(String account);
    int  updateUser(User user);
    User getUserMsgByAccount(String account);
    int singUp(User user);
}
