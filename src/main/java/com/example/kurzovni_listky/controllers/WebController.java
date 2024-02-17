package com.example.kurzovni_listky.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/all-exchange-rates/**")
    public String forwardToReactApp() {
        return "forward:/all-exchange-rates/index.html";
    }

}