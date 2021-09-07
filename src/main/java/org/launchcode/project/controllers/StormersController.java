package org.launchcode.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StormersController {

    @GetMapping("/stormers/index")
    public String Stormers(){

        return "stormers/index";
    }

    @GetMapping("/stormers/form")
    public String displayStormersForm(){

        return "stormers/form";
    }


}
