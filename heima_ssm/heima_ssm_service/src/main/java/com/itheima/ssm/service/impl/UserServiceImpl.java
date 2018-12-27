package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.UserDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户信息,添加时保证用户名唯一
        System.out.println(username);
        UserInfo userInfo = userDao.findByUsername(username);
        System.out.println(userInfo);
        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),userInfo.getStatus()==1?true:false,true,true,true,getRoles(userInfo));
        return user;
    }

    public List<SimpleGrantedAuthority> getRoles(UserInfo userInfo){
        List<SimpleGrantedAuthority> roles = new ArrayList<>();

        for (Role role : userInfo.getRoles()) {
            SimpleGrantedAuthority sga = new SimpleGrantedAuthority("ROLE_"+role.getRoleName());
            roles.add(sga);
        }

        return roles;
    }

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }
}
