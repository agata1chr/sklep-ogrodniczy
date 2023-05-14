package com.tyrytyry.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class pageController {


    @GetMapping("/")
    public String orderForm() {

        return "home";

    }

    @GetMapping("/home")
    public String home(Model model) {

        return "home";
    }


}