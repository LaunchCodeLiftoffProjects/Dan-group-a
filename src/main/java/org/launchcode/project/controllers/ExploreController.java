package org.launchcode.project.controllers;

import org.launchcode.project.data.PostRepository;
import org.launchcode.project.data.TagRepository;
import org.launchcode.project.data.UserRepository;
import org.launchcode.project.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ExploreController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/explore")
    public String explore() {

        return "explore";
    }

    @GetMapping("/explore")
    public String displayPost(@RequestParam Integer postId, Model model) {
        Optional<Post> result = postRepository.findById(postId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Post Id: " + postId);
        } else {
            Post post = result.get();
            model.addAttribute("User", post.getUser());
            model.addAttribute("title", post.getName());
            model.addAttribute("post", post);
            model.addAttribute("tags", post.getTags());
        }

        return "events/detail";
    }

}
