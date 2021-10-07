package org.launchcode.project.controllers;

import org.launchcode.project.data.PostRepository;
import org.launchcode.project.data.TagRepository;
import org.launchcode.project.data.UserRepository;
import org.launchcode.project.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("styleyourevent")
public class StyleYourEventController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("")
    public String displayAllPosts(Model model) {
        model.addAttribute("title", "All Posts");
        model.addAttribute("posts", postRepository.findAll());
        return "styleyourevent/index";
    }

    @GetMapping("create")
    public String displayCreatePostForm(Model model) {
        model.addAttribute("title", "Create Post");
        model.addAttribute(new Post());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("posts", postRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());
        return "styleyourevent/create";
    }

    @PostMapping("create")
    public String processAddPostForm(@ModelAttribute @Valid Post newPost,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Post");
            model.addAttribute(new Post());
            return "styleyourevent/create";
        }
        postRepository.save(newPost);
        return "redirect:";
    }
}

//    @GetMapping(value = "styleyourevent/delete")
//    public String displayDeletePostForm(Model model) {
//        model.addAttribute("title", "Delete Posts");
//        model.addAttribute("posts", postRepository.findAll());
//        return "styleyourevent/delete";
//    }
//
//    @PostMapping(value = "styleyourevent/delete")
//    public String processDeletePostsForm(@RequestParam(required = false) int[] postIds) {
//        if (postIds != null) {
//            for (int id : postIds) {
//                postRepository.deleteById(id);
//            }
//        }
//
//        return "redirect:";
//    }

//}









