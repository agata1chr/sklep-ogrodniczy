package com.tyrytyry.demo.basket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {
    @Autowired
    private Cart cart;

    @Autowired
    private ProductService productService;

    @GetMapping("/cart")
    public String showCart(Model model) {
        model.addAttribute("products", cart.getProducts());
        model.addAttribute("totalPrice", cart.getTotalPrice());
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam("productId") Long productId) {
        // pobierz produkt z bazy danych
        Product product = productService.getProductById(productId);
        cart.addProduct(product);
        return "redirect:/cart";
    }

    @PostMapping("/cart/remove")
    public String removeFromCart(@RequestParam("productId") Long productId) {
        // pobierz produkt z bazy danych
        Product product = productService.getProductById(productId);
        cart.removeProduct(product);
        return "redirect:/cart";
    }
}