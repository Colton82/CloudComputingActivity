package com.gcu.milestone;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import model.UserModel;

@Controller
public class RegisterController 
{
    @GetMapping("/register")
    public String register(Model model)
    {
        model.addAttribute("Model", new UserModel());
        return "/register/register";
    }


    @PostMapping("/processRegistration")
    public String processRegistration(Model model, UserModel userModel)
    {

        model.addAttribute("UserModel", userModel);
        return "redirect:/login";
        

    }

    


}
