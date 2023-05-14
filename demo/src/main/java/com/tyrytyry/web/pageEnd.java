package com.tyrytyry.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageEnd {


    @GetMapping("/end")
    public String pageEnd() {

        return "End.html";
    }


}