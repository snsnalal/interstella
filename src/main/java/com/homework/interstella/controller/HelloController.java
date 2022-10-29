package com.homework.interstella.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping
    public String printHello(Model model){
        model.addAttribute("hello", "hello world!");
        return "hello";
    }
    @GetMapping("/main")
    public String printMain(Model model){
        model.addAttribute("index", "hello index main!");
        return "index";
    }
}
