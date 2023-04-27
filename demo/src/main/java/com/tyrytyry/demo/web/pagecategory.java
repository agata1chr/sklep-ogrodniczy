package com.tyrytyry.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pagecategory {


        @GetMapping("/category")
        public String pageCategory() {


            return "category.html";
        }
}



