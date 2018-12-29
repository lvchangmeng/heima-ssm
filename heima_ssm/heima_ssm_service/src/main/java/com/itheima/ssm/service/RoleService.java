package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll(String str,Integer pageNum,Integer pageSize);

    void saveRole(Role role);


    List<Role> findUserByIdAndAllRole();

    public List<Role> findById(String id);


}
