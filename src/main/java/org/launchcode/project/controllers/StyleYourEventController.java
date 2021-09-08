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
public class StyleYourEventController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("styleyourevent")
    public String displayPosts(@RequestParam(required = false) Integer postId, Model model){

        if (postId == null) {
            model.addAttribute("title", "All Posts");
            model.addAttribute("posts", postRepository.findAll());
        } else {
            Optional<Tag> result = tagRepository.findById(postId);
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid Tag ID: " + postId);
            } else {
                Tag tag = result.get();
                model.addAttribute("title", "Posts in tag: " + tag.getName());
                model.addAttribute("posts", tag.getPosts());
            }
        }

        return "styleyourevent/index";
    }

    @GetMapping("styleyourevent/post")
    public String displayCreatePostForm(Model model) {
        model.addAttribute("title", "Create Post");
        model.addAttribute(new Post());
        model.addAttribute("tags", tagRepository.findAll());
        return "styleyourevent/post";
    }

    @PostMapping("styleyourevent/post")
    public String processCreatePostForm(@ModelAttribute @Valid Post newPost,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Post");
            return "styleyourevent/post";
        }

        postRepository.save(newPost);
        return "redirect:";
    }

    @GetMapping("styleyourevent/delete")
    public String displayDeletePostForm(Model model) {
            model.addAttribute("title", "Delete Posts");
            model.addAttribute("posts",postRepository.findAll());
            return "styleyourevent/delete";
        }

    @PostMapping("styleyourevent/delete")
    public String processDeletePostsForm(@RequestParam(required = false) int[] postIds) {
        if(postIds != null) {
            for (int id : postIds) {
                postRepository.deleteById(id);
            }
        }

        return "redirect:";
    }







}
