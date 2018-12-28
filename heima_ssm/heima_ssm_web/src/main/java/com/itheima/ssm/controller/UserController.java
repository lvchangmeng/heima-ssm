package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.UserInfo;
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
}
