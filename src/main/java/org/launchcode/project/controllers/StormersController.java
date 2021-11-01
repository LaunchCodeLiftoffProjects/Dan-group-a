package org.launchcode.project.controllers;


import org.launchcode.project.data.imagefunctionality.FileUploadUtil;
import org.launchcode.project.data.StormersPostRepository;
import org.launchcode.project.models.StormersPosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
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
    public String processStormersForm(@ModelAttribute StormersPosts newPost, @RequestParam("image")MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        newPost.setPhotos(fileName);
        StormersPosts savedPost = stormersPostRepository.save(newPost);

        String uploadDir = "newPost-photos/" + savedPost.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

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
