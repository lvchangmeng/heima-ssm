package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.ProductDao;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;


    public List<Product> findAll(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return productDao.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    @Override
    public void delProduct(String[] id) {
        if(id != null && id.length>0){
            for (String s : id) {
                productDao.delProduct(s);
            }
        }
    }

    /**
     * 模糊查询
     * @param str
     * @return
     */
    @Override
    public List<Product> findDim(String str) {
            return productDao.findDim(str);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Product findById(String id) {
        return productDao.findById(id);
    }

    /**
     * 修改产品信息方法
     * @param product
     */
    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }


}
