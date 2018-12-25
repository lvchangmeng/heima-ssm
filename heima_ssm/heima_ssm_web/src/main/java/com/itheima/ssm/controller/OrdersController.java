package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/findAll")
    public String findAll(Model model){

        List<Orders> orders = ordersService.findAll();
        model.addAttribute("ordersList", orders);

        return "orders-list";
    }
}
