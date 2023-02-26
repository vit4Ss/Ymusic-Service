package com.example.ymusic;

import com.example.ymusic.Mapper.UserMapper;
import com.example.ymusic.domain.Email;
import com.example.ymusic.domain.User;
import com.example.ymusic.util.DateUtils;
import com.example.ymusic.util.EmailUtils;
import com.example.ymusic.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@Slf4j
class YmusicApplicationTests {
	@Autowired
	UserMapper userMapper;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	HttpServletRequest httpServletRequest;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	DateUtils dateUtils;

	@Autowired
	EmailUtils emailUtils;

	@Resource
	private RedisTemplate<String,String> redisTemplate;

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
	@Test
	public void TestDate(){
		System.out.println(dateUtils.DateFormatsTime());
		System.out.println(dateUtils.DateFormatsDate());
	}

	@Test
	public void TestEmail(){
		Email email = new Email();
		List<String> emailList = new ArrayList<String>();
		emailList.add("1006293043@qq.com");
		//emailList.add("994906875@qq.com");
		email.setSendEmail(emailList);
		email.setTitle("Test");
		email.setText("Test 测试 测试");
		log.info("{}",email);
		emailUtils.sendEmail(email);
	}
	@Test
	void setRedisDemo() {
		ValueOperations<String,String> ops = redisTemplate.opsForValue();    // 首先redisTemplate.opsForValue的目的就是表明是以key，value形式储存到Redis数据库中数据的
		ops.set("111","222222",120, TimeUnit.SECONDS);// 到这里就表明Redis数据库中存储了key为address1，value为zhengzhou的数据了（取的时候通过key取数据）
	}

	@Test
	void getRedis(){
		ValueOperations<String,String> ops = redisTemplate.opsForValue();
		Object value = ops.get("111");
		System.out.println(value);
	}

}
