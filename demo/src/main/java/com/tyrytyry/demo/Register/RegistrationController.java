package com.tyrytyry.demo.Register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register.html";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "Użytkownik o podanej nazwie lub adresie e-mail już istnieje!");
            return "register.html";
        }
        // Zapisz użytkownika do bazy danych
        userRepository.save(user);
        model.addAttribute("message", "Użytkownik został zarejestrowany! Możesz się zalogować!");
        return "register-success";
    }
}