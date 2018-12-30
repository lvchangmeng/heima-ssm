package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.dao.RoleDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.PermissionService;
import com.itheima.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 模糊查询加分页查询所有
     * @param model
     * @param str
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model, String str, @RequestParam(required = false,defaultValue = "1") Integer pageNum,@RequestParam(required = false,defaultValue = "3") Integer pageSize){
        List<Role> roles = roleService.findAll(str,pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(roles);
        model.addAttribute("str",str);
        model.addAttribute("pageInfo",pageInfo);
        return "role-list";
    }
    @RequestMapping("/saveRole")
    public String saveRole(Role role){
        roleService.saveRole(role);
        return "redirect:/role/findAll";
    }

    @RequestMapping("/findById2")
    public String findById2(String id,Model model){
        Role roles = roleService.findById2(id);
        model.addAttribute("role",roles);
        return "role-show";
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public String findUserByIdAndAllRole(String roleId,Model model){

        List<Permission> permissionList = permissionService.findAll();

        List<Permission> permissions = permissionService.findById(roleId);

        for (Permission permission : permissionList) {
            for (Permission permission1 : permissions) {
                if(permission.getId().equals(permission1.getId())){
                    permission.setFlag(1);

                }
            }
        }

        model.addAttribute("roleId",roleId);
        model.addAttribute("permissionList",permissionList);

        return "role-permission-add";
    }

    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(String roleId,String[]ids){
        roleService.deleteByPermissionId(roleId);

        roleService.addPermissionToRole2(roleId,ids);
        return "redirect:/role/findAll";
    }

}
