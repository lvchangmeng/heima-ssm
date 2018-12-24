package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Product;

import java.util.List;

public interface ProductDao {
    /**
     * 查询所有产品方法
     * @return
     */
    public List<Product> findAll();

    /**
     * 添加信息方法
     */
    public void saveProduct(Product product);

    /**
     * 删除方法
     * @param id
     */
    public void delProduct(String id);

}
