package com.example.ymusic.domain;


import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@Data
public class User {
    private  int id;
    private String userName;
    private String password;
    private String email;
    private String mobileNum;
    private String lastLoginIp;
    private String createTime;
    private String lastUpdateTime;
}
