package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.RoleService;
import com.itheima.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    public String findAll(Model model, String str, @RequestParam(required = false,defaultValue = "1") Integer pageNum,@RequestParam(required = false,defaultValue = "3") Integer pageSize){

        List<UserInfo> userInfos = userService.findAll(str,pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(userInfos);
        model.addAttribute("str",str);
        model.addAttribute("pageInfo",pageInfo);
        return "user-list";
    }

    @RequestMapping("/saveUser")
    public String saveUser(UserInfo userInfo){
        String encode = passwordEncoder.encode(userInfo.getPassword());
        userInfo.setPassword(encode);
        userService.saveUser(userInfo);
        return "redirect:/user/findAll";
    }

    /**
     * 用户详情查询
     * @return
     */
    @RequestMapping("/findById")
    public String findById(String id,Model model){
        UserInfo userInfos = userService.findById(id);
        model.addAttribute("user",userInfos);
        System.out.println(userInfos);
        return "user-show";
    }

    /**
     * 根据id查询用户信息,是给修改用的
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/findByUserId")
    public String findByUserId(String id,Model model){

        UserInfo userInfo = userService.findByUserId(id);

        model.addAttribute("user",userInfo);
        return "user-update";
    }

    /**
     * 修改用户信息,密码加密
     * @param userInfo
     * @param oldPwd
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(UserInfo userInfo,String oldPwd){
        if(!oldPwd.equals(userInfo.getPassword())){
            String encode = passwordEncoder.encode(userInfo.getPassword());
            userInfo.setPassword(encode);
        }
        userService.updateUser(userInfo);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public String findUserByIdAndAllRole(Model model,String id){
        List<Role> roleList = roleService.findUserByIdAndAllRole();

        //根据id查询当前用户所拥有的角色
        List<Role> roles = roleService.findById(id);
        for (Role role : roleList) {
            for (Role role1 : roles) {
                if(role.getId().equals(role1.getId())){
                    role.setStatus(1);
                }
            }
        }
        model.addAttribute("id",id);
        model.addAttribute("roleList",roleList);
        return "user-role-add";
    }


    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String userId,String[]ids){

        userService.deleteByuserId(userId);
        userService.addRoleToUser2(userId,ids);

        return "redirect:/user/findAll";
    }
}
