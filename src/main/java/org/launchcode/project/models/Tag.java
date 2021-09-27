package org.launchcode.project.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag extends AbstractEntity {

    @Size(min = 1, max = 25)
    @NotBlank
    public String name;

    @Size(min = 0, max = 50)
    public String description;

    @ManyToMany(mappedBy = "tags")
    public List<Post> posts = new ArrayList<>();

    public Tag(String name, String description){
        this.name= name;
        this.description= description;
    }

    public Tag() {
    }

    public String getName(){ return name;}

    public String getDescription(){
        return description;
    }

    public String getDisplayName() {
        return "#" + name + " ";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description){
        this.description=description;}

    public List<Post> getPosts(){
        return posts;
    }

   }



