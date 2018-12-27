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

    /**
     * 模糊查询
     * @return
     */
    public List<Product> findDim(String str);

    /**
     * 根据id查询产品
     * @param id
     * @return
     */
    public Product findById(String id);

    /**
     * 根据id修改产品信息
     * @param product
     * @return
     */
    public void updateProduct(Product product);

}
