package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/findAll")
    public String findAll(@RequestParam(required = false,defaultValue = "1") Integer pageNum, @RequestParam(required = false,defaultValue = "3") Integer pageSize, Model model){

        List<Orders> orders = ordersService.findAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(orders);
        model.addAttribute("page", pageInfo);

        return "orders-list";
    }


    @RequestMapping("/findById")
    public String findById(String id,Model model){
        Orders oid = ordersService.findById(id);
        model.addAttribute("orders",oid);
        return "orders-show";
    }

    @RequestMapping("/findDim")
    public String findDim(HttpServletRequest request){
        String fo = request.getParameter("foo");
        List<Orders> dim = ordersService.findDim(fo);
        request.setAttribute("ordersList",dim);
        return "orders-list";
    }


}
