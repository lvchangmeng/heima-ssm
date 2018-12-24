package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询所有的产品信息
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
    public void delProduct(String[] id);
}
