package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.sevice.Impl.ProductSeviceImpl;
import com.codegym.sevice.ProductSevice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    private  ProductSevice productSevice = new ProductSeviceImpl();
    @GetMapping("/product")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("product",productSevice.fillAll());
        return modelAndView;
    }
    @GetMapping("product/edit/{id}")
    public ModelAndView editProduct(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("product",productSevice.findById(id));
        return modelAndView;

    }
    @PostMapping("edit-product")
    public ModelAndView saveProduct(@ModelAttribute("product") Product product){
        productSevice.save(product);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("product", productSevice.fillAll());
        return modelAndView;
    }


    @GetMapping("product/delete/{id}")
    public ModelAndView modelAndView(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("product",productSevice.findById(id));
        return modelAndView;
    }
    @PostMapping("delete-product")
    public String deleteProduct(@ModelAttribute("product")Product product){
        productSevice.delete(product.getId());
        return "redirect:/product";

    }
    @GetMapping("create-product")
    public ModelAndView createProduct (){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }
    @PostMapping("create-product")
    public String saveProduct( Product product , RedirectAttributes redirect){
        product.setId((int)(Math.random() * 10000));
        productSevice.save(product);
        redirect.addFlashAttribute("message", "Saved customer successfully!");
        return "redirect:/product";
    }


}
