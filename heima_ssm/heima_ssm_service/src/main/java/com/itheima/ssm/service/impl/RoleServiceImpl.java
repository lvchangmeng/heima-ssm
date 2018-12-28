package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.RoleDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll(String str,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return roleDao.findAll(str);
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }
}
