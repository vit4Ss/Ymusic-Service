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

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ResponseBody
@Controller
@Slf4j
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
            userService.singUp(user);
        return result;
    }
    @RequestMapping("/hello")
    public String HelloRes(){
        return "Hello";
    }

    @RequestMapping("/")
    public void  toRedirect(HttpServletResponse response) throws IOException {
        //"redirect:要访问的相对网址或绝对网址?参数名="+参数值;
        response.sendRedirect("/hello");
    }

}
