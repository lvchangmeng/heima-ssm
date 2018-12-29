package com.itheima.ssm.service;


import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{

    /**
     * 查询所有
     * @return
     */
    List<UserInfo> findAll(String str,Integer pageNum,Integer pageSize);

    /**
     * 保存用户
     * @param userInfo
     */
    void saveUser(UserInfo userInfo);

    UserInfo findById(String id);

    UserInfo findByUserId(String id);

    void updateUser(UserInfo userInfo);

    void deleteByuserId(String userId);

    void addRoleToUser2(String userId, String[] ids);
}
