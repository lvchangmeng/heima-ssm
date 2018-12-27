package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询所有的产品信息
     * @return
     */
    public List<Product> findAll(Integer pageNum,Integer pageSize);

    /**
     * 添加信息方法
     */
    public void saveProduct(Product product);

    /**
     * 删除方法
     * @param id
     */
    public void delProduct(String[] id);

    /**
     * 模糊查询
     * @return
     */
    public List<Product> findDim(String str);

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    public Product findById(String id);

    /**
     * 修改产品信息
     * @param product
     */
    public void updateProduct(Product product);

}
