package com.arnold.www.service;

import com.arnold.www.dao.AuthUserMapper;
import com.arnold.www.pojo.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    AuthUserMapper authUserMapper;

    //根据 账号查询用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //将来连接数据库根据账号查询用户信息
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        UserDto resultUserDto = authUserMapper.getUserByParam(userDto).get(0);
        if(userDto == null){
            //如果用户查不到，返回null，由provider来抛出异常
            return null;
        }
        //根据用户的id查询用户的权限
        List<String> permissions = authUserMapper.findPermissionsByUserId(resultUserDto.getId());
        //将permissions转成数组
        String[] permissionArray = new String[permissions.size()];
        permissions.toArray(permissionArray);
        UserDetails userDetails = User.withUsername(resultUserDto.getUsername()).password(resultUserDto.getPassword()).authorities(permissionArray).build();
        return userDetails;
    }
}
