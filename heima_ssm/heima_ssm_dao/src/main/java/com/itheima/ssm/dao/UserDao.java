package com.itheima.ssm.dao;

import com.itheima.ssm.domain.QueryVo;
import com.itheima.ssm.domain.UserInfo;

import java.util.List;

public interface UserDao {
    /**
     * 登录方法验证
     * @param username
     * @return
     */
    public UserInfo findByUsername(String username);

    List<UserInfo> findAll(String str);

    /**
     * 用户保存
     * @param userInfo
     */
    void saveUser(UserInfo userInfo);

    UserInfo findById(String id);

    UserInfo findByUserId(String id);

    void updateUser(UserInfo userInfo);

    void deleteByuserId(String userId);


    void addRoleToUser2(QueryVo qv);
}
