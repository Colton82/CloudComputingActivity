package com.gcu.milestone;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import business.SecurityServiceInterface;
import model.LoginModel;

@Controller
public class LoginController
{

    @Autowired
    SecurityServiceInterface securityService;

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

        if(securityService.isAuthenticated(loginModel))
        {
            model.addAttribute("LoginModel", loginModel);
            return "loginSuccess";
        }
        else
        {
            model.addAttribute("error", "Invalid Credentials!");
            return "login";
        }

    }

}
