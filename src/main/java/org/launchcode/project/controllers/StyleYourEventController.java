package org.launchcode.project.controllers;
import org.launchcode.project.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String processPostEventForm(@RequestParam String postEvent){
        posts.add(new Post(postEvent));
        return "redirect:";

    }


}
