package com.example.ymusic.util;


import cn.hutool.core.date.DateUtil;
import com.example.ymusic.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.UUID;

/**
 * JWT工具类
 */
@Slf4j
@Data
@Component
@ConfigurationProperties(prefix = "jwttoken.jwt")
public class JwtUtils {
    //有效期为60 * 60 *1000  一个小时
    private  long expired;//过期时长
    //设置秘钥明文 可以放在YML中
    private String secret;//加密串

    private String header;//请求头


    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    //生成JwtToken
    public String generateToken(){
        Date nowDate = new Date();//获取现在的时间

        Date expireDate = new Date(nowDate.getTime() + expired * 1000);//获取过期时间

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setIssuedAt(nowDate)  //生成时间
                .setExpiration(expireDate) //过期时间
                .setSubject(getUUID())
                .setIssuer("YMusic")
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    //解析JwtToken
    public Claims parserJwtToken(String token) {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
    }

    //判断Token是否过期
    public boolean isExpired(Date expiration){
        return expiration.before(new Date());
    }

    //自动刷新token
}