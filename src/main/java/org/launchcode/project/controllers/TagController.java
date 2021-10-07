package org.launchcode.project.controllers;

import org.launchcode.project.data.TagRepository;
import org.launchcode.project.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("add-tag")
    public String displayAddTagForm(Model model) {
        model.addAttribute(new Tag());
        return "tags/add-tag";
    }

    @PostMapping("add")
    public String processAddTagForm(@ModelAttribute @Valid Tag newTag,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Tag");
            model.addAttribute(new Tag());
            return "tags/add-tag";
        }
        tagRepository.save(newTag);
        return "redirect:";
    }

    @GetMapping("view/{tagId}")
    public String displayViewTag (Model model, @PathVariable int tagId) {
        Optional<Tag> optTag = tagRepository.findById(tagId);
        if (optTag.isPresent()) {
            Tag tag = (Tag) optTag.get();
            model.addAttribute("tag", tag);
            return "tags/view";
        } else {
            return "redirect:../";
        }
    }
}
