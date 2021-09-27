package org.launchcode.project.controllers;


import org.launchcode.project.data.StormersPostRepository;
import org.launchcode.project.models.StormersPosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("search")
public class StormersSearchController {

    @Autowired
    private StormersPostRepository stormersPostRepository;

//    @RequestMapping
//    public String processStormersForm(@ModelAttribute StormersPosts newPost){
//        stormersPostRepository.save(newPost);
//        return "redirect:index";
//    }

    @RequestMapping("view/{id}")
    public String displayStormersPost(Model model,@PathVariable int id, @RequestParam String searchTerm, @ModelAttribute StormersPosts posts){


        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            model.addAttribute("posts", stormersPostRepository.findAll());
        } else if (searchTerm.toLowerCase().equals(posts.getName())) {
           model.addAttribute("posts", posts.getName());
        }



//        Optional optStormersPost = stormersPostRepository.findById(id);
//        if(optStormersPost.isPresent()){
//            StormersPosts stormersPost = (StormersPosts) optStormersPost.get();
//            model.addAttribute("stormersPost", stormersPost);
//
//        }

        return "stormers/searchresults";
    }
}
