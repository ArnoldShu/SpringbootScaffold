package com.arnold.www.config;

import com.arnold.www.dao.AuthUserMapper;
import com.arnold.www.pojo.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author Arnold
 * @version V1.0
 * @className UserInitConfig
 * @description TODO
 * @date 2020/5/30
 **/
@Component
public class UserInitConfig {
    /*@Autowired
    private AuthUserMapper authUserMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init(){
        authUserMapper.add(
                new UserDto().setUsername("admin")
                        .setFullname("admin")
                        .setPassword(passwordEncoder.encode("admin"))
                        .setMobile("1234567890")
        );
        authUserMapper.add(
                new UserDto().setUsername("arnold")
                        .setFullname("arnold")
                        .setPassword(passwordEncoder.encode("arnold"))
                        .setMobile("1234567890")
        );
    }*/
}