package com.wipro.joydeep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wipro.joydeep.model.UserDetails;

@Controller
public class LoginController {
    @GetMapping({"/", "/login"})
    public String login(Model model)
    {
       model.addAttribute("userdetails",new UserDetails());
       return "Login";
    }
    
    @GetMapping({"/admin-login-screen"})
    public String adminlogin(Model model)
    {
       model.addAttribute("userdetails",new UserDetails());
       return "AdminLogin";
    } 
    
    
    
}
