package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.RoleDao;
import com.itheima.ssm.domain.QueryVoPermissionToRole;
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

    @Override
    public List<Role> findUserByIdAndAllRole() {
        return roleDao.findUserByIdAndAllRole();
    }

    @Override
    public List<Role> findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public Role findById2(String id) {
        return roleDao.findById2(id);
    }

    @Override
    public void deleteByPermissionId(String roleId) {
        roleDao.deleteByPermissionId(roleId);
    }

    @Override
    public void addPermissionToRole2(String roleId, String[] ids) {
        QueryVoPermissionToRole qvt = new QueryVoPermissionToRole();
        for (String id : ids) {
            System.out.println(id);
            qvt.setRoleId(roleId);
            qvt.setPermissionId(id);
            roleDao.addPermissionToRole2(qvt);
        }
    }


}
