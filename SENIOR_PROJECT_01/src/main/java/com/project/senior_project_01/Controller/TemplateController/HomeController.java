package com.project.senior_project_01.Controller.TemplateController;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.project.senior_project_01.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @GetMapping({"/", "/shop"})
    public String shop(Model model){

        model.addAttribute("products", productService.getAllProductFromPage());
        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable int id){
        model.addAttribute("product", productService.getProductById(id).get());

        return "viewProduct";
    }
}
