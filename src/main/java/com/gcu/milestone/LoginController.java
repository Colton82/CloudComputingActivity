package com.gcu.milestone;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.LoginModel;

@Controller
public class LoginController
{
    @GetMapping("/login")
    public String display(Model model)
    {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }


    @PostMapping("/processLogin")
    public String processLogin(LoginModel loginModel, BindingResult br, Model model)
    {
        if(br.hasErrors())
        {
            model.addAttribute("title", "Login Form");
            return "login";
        }

        // NOT COMPLETE: authenticate user....

        return "login";
    }

}
