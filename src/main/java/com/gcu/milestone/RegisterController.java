package com.gcu.milestone;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import model.UserModel;

@Controller
public class RegisterController 
{
    @GetMapping("/register")
    public String register(Model model)
    {
        System.out.println("REGISTER CONTROLLER");
        model.addAttribute("Model", new UserModel());
        return "register";
    }
}
