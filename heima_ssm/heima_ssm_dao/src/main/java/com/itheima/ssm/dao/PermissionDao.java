package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;

import java.util.List;

public interface PermissionDao {
    public List<Permission> findByRoleId(String RoleId);
}
