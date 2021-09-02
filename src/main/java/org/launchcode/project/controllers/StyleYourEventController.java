package org.launchcode.project.controllers;
import org.launchcode.project.data.PostRepository;
import org.launchcode.project.data.TagRepository;
import org.launchcode.project.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StyleYourEventController {

    private static List<Post> posts = new ArrayList<>();

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("styleyourevent")
    public String displayStyleYourEventForm(Model model){
        model.addAttribute("title", "Create Post");
        model.addAttribute(new Post());
        model.addAttribute("tags", tagRepository.findAll());
        return "/styleyourevent/styleyourevent";
    }

    @PostMapping("styleyourevent/post")
    public String processPostEventForm(@ModelAttribute @Valid Post newPost,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Post");
            return "/styleyourevent/post";
        }

        postRepository.save(newPost);
        return "redirect:";
    }


}
