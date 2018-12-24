package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> findAll();
}
