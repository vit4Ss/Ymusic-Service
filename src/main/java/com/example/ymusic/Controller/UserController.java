package com.example.ymusic.Controller;


import com.example.ymusic.Service.UserService;
import com.example.ymusic.Vo.Result;
import com.example.ymusic.Vo.ResultEnum;
import com.example.ymusic.domain.LoginUser;
import com.example.ymusic.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ResponseBody
@Controller
@Slf4j
public class UserController {
    @Autowired
    UserService userService;



//    @RequestMapping("/hello")
//    public String HelloRes(){
//        UserDetails user = new LoginUser(user);
//        return "Hello";
//    }


    @RequestMapping("/hello")
    public String HelloRes() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        //String password = userDetails.getPassword();
       // List<GrantedAuthority> authorities = (List<GrantedAuthority>) userDetails.getAuthorities();
        return "hello"+username;
    }

    @RequestMapping("/")
    public void  toRedirect(HttpServletResponse response) throws IOException {
        //"redirect:要访问的相对网址或绝对网址?参数名="+参数值;
        response.sendRedirect("/hello");
    }

}
