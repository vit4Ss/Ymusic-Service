package com.example.ymusic.domain;


import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int id;
    private String account;
    private String username;
    private String password;
    private Date createTime;
    private Date updateTime;
}
