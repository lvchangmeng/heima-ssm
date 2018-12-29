package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;

import java.util.List;

public interface RoleDao {
    public List<Role> findById(String id);

    List<Role> findAll(String str);

    void saveRole(Role role);


    List<Role> findUserByIdAndAllRole();

}
