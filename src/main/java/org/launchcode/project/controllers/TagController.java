package org.launchcode.project.controllers;

import org.launchcode.project.data.TagRepository;
import org.launchcode.project.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

//    @GetMapping
//    public String displayTags(Model model) {
//        model.addAttribute("title", "All Tags");
//        model.addAttribute("tags", tagRepository.findAll());
//        return "tags/index";
//    }

    @GetMapping("add-tag")
    public String displayAddTagForm(Model model) {
        model.addAttribute(new Tag());
        return "tags/add-tag";
    }

    @PostMapping("add-tag")
    public String processAddTagForm(@ModelAttribute @Valid Tag newTag,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Tag");
            model.addAttribute(new Tag());
            return "tags/add-tag";
        }
        tagRepository.save(newTag);
        return "redirect:styleyourevent/create";
    }

}
