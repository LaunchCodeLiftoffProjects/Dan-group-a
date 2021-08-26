package org.launchcode.project.controllers;
import org.launchcode.project.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StyleYourEventController {

    private static List<Post> posts = new ArrayList<>();

    @GetMapping("styleyourevent")
    public String StyleYourEvent(){

        return "styleyourevent";
    }

    @PostMapping("styleyourevent")
    public String processPostEventForm(@ModelAttribute @Valid Post newPost, Error errors, Model model){

        if(errors.hasErrors()){
            model.addAttribute("title","Create Post");
            return "styleyourevent";
        }

        stylestormRepository.save(postEvent);
        return "redirect:";
    }


}
