package org.launchcode.project.controllers;

import org.launchcode.project.data.PostRepository;
import org.launchcode.project.data.TagRepository;
import org.launchcode.project.data.UserRepository;
import org.launchcode.project.models.DTO.PostTagDTO;
import org.launchcode.project.models.Post;
import org.launchcode.project.models.Tag;
import org.launchcode.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
        model.addAttribute(new Post());
        return "styleyourevent/create";
    }

    @PostMapping("create")
    public String processCreatePostForm(@ModelAttribute @Valid Post newPost, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Post");
            model.addAttribute(new Post());
            return "styleyourevent/create";
        }

        postRepository.save(newPost);
        return "redirect:";

    }

    @GetMapping("styleyourevent/delete")
    public String displayDeletePostForm(Model model) {
        model.addAttribute("title", "Delete Posts");
        model.addAttribute("posts", postRepository.findAll());
        return "styleyourevent/delete";
    }

    @PostMapping("styleyourevent/delete")
    public String processDeletePostsForm(@RequestParam(required = false) int[] postIds) {
        if (postIds != null) {
            for (int id : postIds) {
                postRepository.deleteById(id);
            }
        }

        return "redirect:";
    }

    // responds to /events/add-tag?eventId=13
    @GetMapping("add-tag")
    public String displayAddTagForm(@RequestParam Integer postId, Model model){
        Optional<Post> result = postRepository.findById(postId);
        Post post = result.get();
        model.addAttribute("title", "Add Tag to: " + post.getName());
        model.addAttribute("tags", tagRepository.findAll());
        PostTagDTO postTag = new PostTagDTO();
        postTag.setPost(post);
        model.addAttribute("postTag", postTag);
        return "events/add-tag.html";
    }

    @PostMapping("add-tag")
    public String processAddTagForm(@ModelAttribute @Valid PostTagDTO postTag,
                                    Errors errors,
                                    Model model){

        if (!errors.hasErrors()) {
            Post post = postTag.getPost();
            Tag tag = postTag.getTag();
            if (!post.getTags().contains(tag)){
                post.addTag(tag);
                postRepository.save(post);
            }
            return "redirect:detail?postId=" + post.getId();
        }

        return "redirect:add-tag";
    }












}










