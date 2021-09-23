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
import java.util.List;
import java.util.Optional;

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

    @GetMapping("styleyourevent/create")
    public String displayCreatePostForm(Model model) {
        model.addAttribute("title", "Add Post");
        model.addAttribute(new Post());
        model.addAttribute("posts", postRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());

        return "styleyourevent/create";
    }

    @PostMapping("styleyourevent/create")
    public String processCreatePostForm(@ModelAttribute @Valid Post newPost, Tag newTag,
                                        Errors errors, Model model, @RequestParam int postId, @RequestParam List<Integer> tags) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Post");
            return "styleyourevent/create";
        }else {
            model.addAttribute("title", "Create Post");
            Optional<Post> result = postRepository.findById(postId);
            Iterable<Tag> tagResult = tagRepository.findAllById(tags);
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid Post ID: " + postId);
            } else {
                Post post = result.get();
                newPost.setPost(post);
                model.addAttribute("title", "Posts in tag: " + post.getName());
                model.addAttribute("posts", post.getTags());
            }
                newPost.setTags((List<Tag>) tagResult);

            postRepository.save(newPost);
            return "redirect:";

        }


    }

    @PostMapping("styleyourevent/add-tag")
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








