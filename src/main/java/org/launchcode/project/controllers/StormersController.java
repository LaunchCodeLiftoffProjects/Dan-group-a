package org.launchcode.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StormersController {

    @GetMapping("/stormers")
    public String Stormers(){

        return "stormers";
    }
}
