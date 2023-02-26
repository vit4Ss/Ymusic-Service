package com.example.ymusic.Controller;


import com.example.ymusic.Service.UserService;
import com.example.ymusic.Vo.Result;
import com.example.ymusic.Vo.ResultEnum;
import com.example.ymusic.domain.LoginUser;
import com.example.ymusic.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    AuthenticationManager authenticationManager;

//    @RequestMapping("/hello")
//    public String HelloRes(){
//        UserDetails user = new LoginUser(user);
//        return "Hello";
//    }


    @RequestMapping("/hello")
    public Result<Object> HelloRes() {
        log.info("Hello");
        Result<Object> result = new Result<Object>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser userDetails = (LoginUser) authentication.getPrincipal();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(userDetails);
        //String password = userDetails.getPassword();
       // List<GrantedAuthority> authorities = (List<GrantedAuthority>) userDetails.getAuthorities();
        return result;
    }

    @RequestMapping("/")
    public void  toRedirect(HttpServletResponse response) throws IOException {
        //"redirect:要访问的相对网址或绝对网址?参数名="+参数值;
        response.sendRedirect("/hello");
    }

    @PostMapping("/login")
    public Result<Object> login(@RequestBody User user) {
        Result<Object> result = new Result<Object>();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(authenticate==null){
            throw new RuntimeException("用户名或密码错误");
        }
        //使用userid生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        //String userId = loginUser.getUser().getId().toString();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(loginUser);
        return result;
    }
}
