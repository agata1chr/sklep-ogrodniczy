package com.tyrytyry.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageBasket {

        @GetMapping("/basket")
        public String pageBasket() {


            return "basket.html";
        }
}


