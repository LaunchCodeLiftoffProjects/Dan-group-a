package org.launchcode.project.controllers;
import org.launchcode.project.data.PostRepository;
import org.launchcode.project.data.TagRepository;
import org.launchcode.project.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.launchcode.project.models.dto.EventTagDTO;

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

    @GetMapping("post")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Post");
        model.addAttribute(new Post());
        model.addAttribute("tags", tagRepository.findAll());
        return "styleyourevent/post";
    }

    @PostMapping("post")
    public String processCreateEventForm(@ModelAttribute @Valid Post newPost,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            return "events/create";
        }

        postRepository.save(newPost);
        return "redirect:";
    }

    @GetMapping("add-tag")
    public String displayAddTagForm(@RequestParam Integer postId, Model model){
        Optional<Post> result = postRepository.findById(postId);
        Post post = result.get();
        model.addAttribute("title", "Add Tag to: " + post.getName());
        model.addAttribute("tags", tagRepository.findAll());
        EventTagDTO postTag = new EventTagDTO();
        postTag.setPost(post);
        model.addAttribute("postTag",postTag);
        return "styleyourevent/add-tag.html";
    }


}
