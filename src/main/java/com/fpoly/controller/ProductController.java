package com.fpoly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpoly.dao.ProductDAO;
import com.fpoly.model.Product;
import com.fpoly.model.SearchForm;

@Controller
public class ProductController {

    @Autowired
    ProductDAO productDAO;

    @GetMapping("/product/index")
    public String index(Model model) {
        var products = productDAO.findAll();
        model.addAttribute("searchResults", products);
        model.addAttribute("searchForm", new SearchForm()); 

        return "product/index";
    }


    @GetMapping("/product/search")
    public String search(@RequestParam("searchText") String searchText, Model model) {

        List<Product> searchResults = productDAO.findByNameLike("%"+searchText+"%");

        model.addAttribute("searchResults", searchResults);
        model.addAttribute("searchForm", new SearchForm()); 

        return "product/index";
    }
}
