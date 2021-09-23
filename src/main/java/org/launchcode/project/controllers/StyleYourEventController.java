package org.launchcode.project.controllers;

import org.launchcode.project.data.PostRepository;
import org.launchcode.project.data.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@Controller
@RequestMapping("/styleyourevent")
public class StyleYourEventController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "All Posts");
        model.addAttribute("posts", postRepository.findAll());
        return "styleyourevent/index";
    }

    @GetMapping("create")
    public String displayCreatePostForm(Model model) {
        model.addAttribute(new Post());
        return "styleyourevent/create";
    }

    @PostMapping(value = "styleyourevent/create")
    public String processCreatePostForm(@ModelAttribute @Valid Post newPost,
                                        Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Post");
            model.addAttribute(new Post());
            return "styleyourevent/create";
        }

        postRepository.save(newPost);
        return "redirect:";
    }

    @PostMapping(value = "styleyourevent/add-tag")
    public String processAddTagForm(@ModelAttribute @Valid Tag newTag,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Tag");
            model.addAttribute(new Tag());
            return "styleyourevent/add-tag";
        }

        tagRepository.save(newTag);
        return "redirect:";
    }

//    @GetMapping("view/{postId}")
//    public String displayViewPosts(Model model, @PathVariable int postId) {
//        Optional<Post> optPost = postRepository.findById(postId);
//        if (optPost.isPresent()) {
//            Post post = (Post) optPost.get();
//            model.addAttribute("post", post);
//            return "styleyourevent/view";
//        } else {
//            return "redirect:../";
//        }
//    }
//
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

}








