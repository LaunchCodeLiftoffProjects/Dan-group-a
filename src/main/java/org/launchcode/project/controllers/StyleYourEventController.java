package org.launchcode.project.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StyleYourEventController {

    @GetMapping("/styleyourevent")
    public String StyleYourEvent(){

        return "styleyourevent";
    }


}
