package com.tyrytyry.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class pageController {


    @GetMapping("/current")
    public String orderForm(Model model) {
  //      model.addAttribute("order", new Order());
        return "orderForm";

    }
}