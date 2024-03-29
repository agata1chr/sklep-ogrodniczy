package com.tyrytyry.web;

import com.tyrytyry.product.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/")
public class pageController {

    @GetMapping("/")
    public String orderForm() {

        return "home";

    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("1", "Truskawka Polka", 4.50, "produkty/roxana-kaboli-W0L2LbXoEQI-unsplash%201.png"));
        products.add(new Product("2", "Doniczki kwiatowe", 5.49, "produkty/linh-le-Ebwp2-6BG8E-unsplash%201.png"));
        products.add(new Product("4", "Marchew Berlikum", 5.29 , "produkty/michael-c-ncK1abCfC90-unsplash%201.png"));
        products.add(new Product("3", "Mak wschodni", 4.15, "produkty/zhen-hu-SauU_zQ5ZKA-unsplash%201.png"));
        model.addAttribute("products", products);
        return "home";
    }


}