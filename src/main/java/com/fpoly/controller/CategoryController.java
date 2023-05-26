package com.fpoly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.dao.CategoryDAO;
import com.fpoly.model.Category;

@Controller
public class CategoryController {
    @Autowired
    CategoryDAO dao;

    @RequestMapping("/category/index") 
    public String index(Model model) {
        Category item = new Category(); 
        model.addAttribute("item", item); 
        List<Category> items = dao.findAll(); 
        model.addAttribute("items", items); 
        return "category/index";
    }
}
