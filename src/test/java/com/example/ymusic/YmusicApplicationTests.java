package com.example.ymusic;

import com.example.ymusic.Mapper.UserMapper;
import com.example.ymusic.domain.User;
import com.example.ymusic.util.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@SpringBootTest
class YmusicApplicationTests {
	@Autowired
	UserMapper userMapper;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	HttpServletRequest httpServletRequest;

	@Autowired
	JwtUtils jwtUtils;


	@Test
	public void userMapperTest(){
		User user = userMapper.getUserMsgByAccount("test");
		System.out.println(user);
	}


	@Test
	public void TestEnCode(){
		System.out.println(passwordEncoder.encode("123456"));
	}
	@Test
	public void TestIPAddress(){
		System.out.println(httpServletRequest.getRemoteAddr());
	}


	@Test
	public void TestToken(){
		System.out.println(jwtUtils.getSecret());
		System.out.println(JwtUtils.getUUID());
		String token = jwtUtils.generateToken();
		System.out.println(token);
		System.out.println(jwtUtils.parserJwtToken(token));
	}
}
