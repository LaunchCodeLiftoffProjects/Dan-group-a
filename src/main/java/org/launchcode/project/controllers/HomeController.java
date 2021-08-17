package org.launchcode.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String index() {

        return "index";
    }

    @GetMapping("/explore")
    public String explore() {

        return "explore";
    }

    @GetMapping("/Home")
    public String Home(){

        return "Home";

    }

}
