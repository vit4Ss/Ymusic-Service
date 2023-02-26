package com.example.ymusic.Vo;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public Result(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public Result(ResultEnum resultEnum,T data) {
        this(resultEnum);
        this.data = data;
    }
    public Result() {

    }
}

