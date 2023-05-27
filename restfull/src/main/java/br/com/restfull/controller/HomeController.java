package br.com.restfull.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/produto")
    public String home() {
        return "produto/home";
    }
}

