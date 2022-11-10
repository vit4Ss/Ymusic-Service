package com.example.ymusic.Controller;


import com.example.ymusic.Service.UserService;
import com.example.ymusic.Vo.Result;
import com.example.ymusic.Vo.ResultEnum;
import com.example.ymusic.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping("/singUp") // 注册
    public Result userSingup(User user){
        Result result = null;
        if(userService.getUserByAccount(user.getAccount())>1){
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setData("该账户已存在");
            return result;
        }
        else
            userService.singUp(user);
        return result;
    }

}
