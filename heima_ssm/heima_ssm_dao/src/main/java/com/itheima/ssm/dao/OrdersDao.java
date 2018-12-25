package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Orders;

import java.util.List;

public interface OrdersDao {
    /**
     * 查询所有订单
     * @return
     */
    public List<Orders> findAll();


}
