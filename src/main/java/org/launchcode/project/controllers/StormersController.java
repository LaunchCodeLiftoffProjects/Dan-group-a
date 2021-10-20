package org.launchcode.project.controllers;

import org.launchcode.project.data.FileUploadServlet;
import org.launchcode.project.data.StormersPostRepository;
import org.launchcode.project.models.StormersPosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("stormers")

public class StormersController {

    @Autowired
    private StormersPostRepository stormersPostRepository;



    @GetMapping("index")
    public String Stormers(Model model){
            model.addAttribute("posts", stormersPostRepository.findAll());
        return "stormers/index";
    }

    @GetMapping("form")
    public String createStormersForm(){

        return "stormers/form";
    }

    @PostMapping("form")
    public String processStormersForm(@ModelAttribute StormersPosts newPost){
        stormersPostRepository.save(newPost);
        return "redirect:index";
    }

    @GetMapping("view/{id}")
    public String displayStormersPost(Model model,@PathVariable int id){

        Optional optStormersPost = stormersPostRepository.findById(id);
        if(optStormersPost.isPresent()){
            StormersPosts stormersPost = (StormersPosts) optStormersPost.get();
            model.addAttribute("stormersPost", stormersPost);


        }

        return "stormers/view";
    }


}
