package org.launchcode.project.controllers;

import org.launchcode.project.models.stormers.Posts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("stormers")
public class StormersController {

    private static List<Posts> posts = new ArrayList<>();

    @GetMapping("index")
    public String Stormers(Model model){
            model.addAttribute("posts", posts);
        return "stormers/index";
    }

    @GetMapping("form")
    public String createStormersForm(){

        return "stormers/form";
    }

    @PostMapping("form")
    public String processStormersForm(@ModelAttribute Posts newPost){
        posts.add(newPost);
        return "redirect:index";
    }

    @GetMapping("view")
    public String displayStormersPost(Model model, @ModelAttribute Posts post){

        return "stormers/posts";
    }


}
