package org.launchcode.project.controllers;

import org.launchcode.project.data.UserRepository;
import org.launchcode.project.models.Post;
import org.launchcode.project.models.Tag;
import org.launchcode.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Optional;

public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("users")
    public String displayUsers(@RequestParam(required = false) Integer userId, Model model) {
        model.addAttribute("title", "All Users");
        model.addAttribute("users", userRepository.findAll());
        return "users/index";
    }

    @GetMapping("users")
    public String displayCreateUserForm(@RequestParam(required = false) Integer postId, Model model) {
        model.addAttribute("title", "Create User");
        model.addAttribute(new User());
        model.addAttribute("users", userRepository.findAll());
        return "users/create";
    }

    @PostMapping("users")
    public String processCreateUserForm(@ModelAttribute @Valid User newUser,
                                        Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create User");
            model.addAttribute(new User());
            return "users/create";
        }

        userRepository.save(newUser);
        return "redirect:";
    }
}

