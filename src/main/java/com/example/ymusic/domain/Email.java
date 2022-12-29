package com.example.ymusic.domain;


import lombok.Data;

import java.util.List;

@Data
public class Email {
    private List<String> sendEmail;
    private String Title;
    private String text;
}
