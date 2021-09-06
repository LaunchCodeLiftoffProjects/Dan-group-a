package org.launchcode.project.controllers;
import org.launchcode.project.data.PostRepository;
import org.launchcode.project.data.TagRepository;
import org.launchcode.project.models.Post;
import org.launchcode.project.models.Tag;
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
@RequestMapping("styleyourevent")
public class StyleYourEventController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagRepository tagRepository;

    private static List<Post> posts = new ArrayList<>();


    @GetMapping
    public String displayAllEvents(@RequestParam(required=false) Integer categoryId, Model model) {
        if (categoryId == null){
            model.addAttribute("title","All Posts");
            model.addAttribute("posts",postRepository.findAll());
        }else {
            Optional<Tag> result = tagRepository.findById(categoryId);
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid Category ID: " + categoryId);
            } else {
                Tag tag = result.get();
                model.addAttribute("title", "Posts in tag: " + tag.getName());
                model.addAttribute("posts", tag.getPosts());
            }
        }
        return "/styleyourevent/styleyourevent";
    }

    @PostMapping("styleyourevent")
    public String processPostEventForm(@ModelAttribute @Valid Post newPost, Errors errors, Model model){

        if(errors.hasErrors()){
            model.addAttribute("title","Create Post");
            return "styleyourevent/post";
        }

        postRepository.save(newPost);
        return "redirect:";
    }


}
