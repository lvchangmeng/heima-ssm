package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 查询所有产品表信息
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList",ps);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/saveProduct")
    public String saveProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/product/findAll";
    }

    @RequestMapping("/delProduct")
    public String delProduct(HttpServletRequest request){
        String[] ids = request.getParameterValues("ids");
        for (String id : ids) {

            System.out.println(id);
        }
        productService.delProduct(ids);
        return "redirect:/product/findAll";
    }


    /**
     * 模糊查询
     * @param request
     * @return
     */
    @RequestMapping("/findDim")
    public String findDim(HttpServletRequest request){
        String fo = request.getParameter("fo");
        List<Product> dim = productService.findDim(fo);
        request.setAttribute("productList",dim);
        return "product-list";
    }

}
