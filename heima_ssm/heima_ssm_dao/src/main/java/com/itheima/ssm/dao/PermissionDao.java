package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;

import java.util.List;

public interface PermissionDao {
    public List<Permission> findByRoleId(String RoleId);

    List<Permission> findAll();

    void savePermission(Permission permission);

    List<Permission> findById(String id);
}
