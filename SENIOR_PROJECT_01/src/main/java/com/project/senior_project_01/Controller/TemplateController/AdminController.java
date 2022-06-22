package com.project.senior_project_01.Controller.TemplateController;
import java.util.Optional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.project.senior_project_01.Entity.Product;
import com.project.senior_project_01.Service.UserService;
import com.project.senior_project_01.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.senior_project_01.Repository.UserRepository;

@Controller
public class AdminController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

//-----------------------------------------------------------product-----------------------------------------------------
    @Autowired
    ProductService productService;
    @GetMapping("/admin/products")
    public String getProduct(Model model){
        model.addAttribute("products", productService.getAllProductFromPage());
        return "products";
    }
    @GetMapping("/admin/products/add")
    public String getProductAdd(Model model){
        model.addAttribute("product", new Product());
        return "productsAdd";
    }
    @PostMapping("/admin/products/add")
    public String postProductAdd(@ModelAttribute("product") Product product){

        productService.addProductFromPage(product);
        return "redirect:/admin/products";
    }
    @GetMapping("/admin/products/delete/{id}")
    public String deleteProduct(@PathVariable int id){

        productService.removeProductByIdFromPage(id);
        return "redirect:/admin/products";
    }
    @GetMapping("/admin/products/update/{id}")
    public String updateProduct(@PathVariable int id, Model model){
        Optional<Product> product = productService.getProductByIdFromPage(id);

        if (product.isPresent()){
            model.addAttribute("product", product.get());
            return "productsAdd";
        }
        else
            return "404";
    }



















}
