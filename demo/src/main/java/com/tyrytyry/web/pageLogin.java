package com.tyrytyry.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageLogin {


        @GetMapping("/login")
        public String pageLogin() {


            return "login.html";
        }


    }



