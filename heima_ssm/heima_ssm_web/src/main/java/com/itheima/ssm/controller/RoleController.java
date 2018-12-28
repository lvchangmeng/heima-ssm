package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.dao.RoleDao;
import com.itheima.ssm.domain.Role;
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

    /**
     * 模糊查询加分页查询所有
     * @param model
     * @param str
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model, String str, @RequestParam(required = false,defaultValue = "1") Integer pageNum,@RequestParam(required = false,defaultValue = "1") Integer pageSize){
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

}
