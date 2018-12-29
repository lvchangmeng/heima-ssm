package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.UserDao;
import com.itheima.ssm.domain.QueryVo;
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


    /**
     * 用户安全登录方法
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户信息,添加时保证用户名唯一

        UserInfo userInfo = userDao.findByUsername(username);

        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==1?true:false,true,true,true,getRoles(userInfo));
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

    /**
     * 用户查询所有方法
     * @return
     */
    @Override
    public List<UserInfo> findAll(String str,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return userDao.findAll(str);
    }

    /**
     * 用户添加方法
     * @param userInfo
     */
    @Override
    public void saveUser(UserInfo userInfo) {
        userDao.saveUser(userInfo);
    }

    /**
     * 用户查询详情
     * @param id
     * @return
     */
    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public UserInfo findByUserId(String id) {
        return userDao.findByUserId(id);
    }

    /**
     * 修改用户信息
     * @param userInfo
     */
    @Override
    public void updateUser(UserInfo userInfo) {
        userDao.updateUser(userInfo);
    }

    @Override
    public void deleteByuserId(String userId) {
        userDao.deleteByuserId(userId);
    }

    @Override
    public void addRoleToUser2(String userId, String[] ids) {
        QueryVo qv = new QueryVo();
        for (String id : ids) {
            qv.setUserId(userId);
            qv.setRoleId(id);

            userDao.addRoleToUser2(qv);
        }

    }
}
