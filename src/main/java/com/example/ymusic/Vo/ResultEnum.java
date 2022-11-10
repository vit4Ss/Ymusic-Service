package com.example.ymusic.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {
    SUCCESS(200,"成功"),
    FAIL(500,"失败"),
    ;
    private final Integer code;
    private final String msg;
}

