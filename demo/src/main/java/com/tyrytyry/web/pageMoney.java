package com.tyrytyry.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import com.tyrytyry.Order;
import com.tyrytyry.web.OrderRepository;

@Controller
@SessionAttributes("order")
public class pageMoney {

   private Order order;

    public pageMoney() {
        this.order = new Order();
    }

    @GetMapping("/money")
    public String pageMoney() {
        return "money.html";
    }

    @ModelAttribute("order")
    public Order order() {
        return this.order;
    }


    @PostMapping("/order")
    public String processOrder(@ModelAttribute("order")Order order, Errors errors,
                               SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "money.html";
        }

        return "redirect:/";
    }

}
