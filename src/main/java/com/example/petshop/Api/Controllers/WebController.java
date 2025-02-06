package com.example.petshop.Api.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title", "Pet Shop");
        return "home/index";
    }
}
