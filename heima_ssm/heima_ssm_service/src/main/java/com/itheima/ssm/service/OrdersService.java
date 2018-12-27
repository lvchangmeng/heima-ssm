package com.itheima.ssm.service;

import com.itheima.ssm.domain.Orders;

import java.util.List;

public interface OrdersService {

    public List<Orders> findAll(Integer pageNum,Integer pageSize);

    public Orders findById(String id);
}
