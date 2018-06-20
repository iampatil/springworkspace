package com.system.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController
{
    @RequestMapping("/admin")
    public ModelAndView admin()
    {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        
        String welcomeMessage = "Welcome "+authentication.getName()+"!!";
        return new ModelAndView("admin", "welcomeMessage", welcomeMessage);
    }

    @RequestMapping("/error")
    public String error(ModelMap model)
    {
        model.addAttribute("error", "true");
        return "login";

    }

    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }
    @RequestMapping("/logout")
    public String logout(ModelMap model)
    {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        authentication.setAuthenticated(false);
        
        model.addAttribute("logout", "true");
        return "login";
    }
}