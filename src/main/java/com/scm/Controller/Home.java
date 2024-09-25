package com.scm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    @GetMapping("/home")
    public String home(Model model){
        System.out.println("I am here!");
        model.addAttribute("name", "Ayush Raghuwanshi");
        return "Home";
    }


    @GetMapping("/about")
    public String about(Model model){
        System.out.println("I am here!");
        model.addAttribute("name", "Ayush Raghuwanshi");
        return "about";
    }

    @GetMapping("/services")
    public String services(Model model){
        System.out.println("I am here!");
        model.addAttribute("name", "Ayush Raghuwanshi");
        return "services";
    }

    @GetMapping("/contact")
    public String contact(Model model){
        System.out.println("I am here!");
        model.addAttribute("name", "Ayush Raghuwanshi");
        return "contact";
    }


    @GetMapping("/login")
    public String login(Model model){
        System.out.println("I am here!");
        model.addAttribute("name", "Ayush Raghuwanshi");
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        System.out.println("I am here!");
        model.addAttribute("name", "Ayush Raghuwanshi");
        return "register";
    }

}
