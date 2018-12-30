package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;

import java.util.List;

public interface PermissionService {

    public List<Permission> findAll();

    void savePermission(Permission permission);

    List<Permission> findById(String id);
}
