package com.fpoly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.fpoly.dao.CategoryDAO;
import com.fpoly.model.Category;

@Controller
public class CategoryController {
 
    @Autowired
    CategoryDAO categoryDAO;

    @GetMapping("/category/index")
    public String getCategories(Model model) {
        var category = new Category();
        model.addAttribute("category", category);
        var categories = categoryDAO.findAll();
        for (Category cat : categories) {
            System.out.println(cat.getProducts().size());
        }
        model.addAttribute("categories", categories);
            return "category/index";
    }

    @GetMapping("/category/save")
    public String saveCategory(@ModelAttribute("category") Category cat ,Model model) {
        categoryDAO.save(cat);
        return this.getCategories(model);
    }
}
