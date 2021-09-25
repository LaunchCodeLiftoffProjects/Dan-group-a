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

    @ManyToMany(mappedBy = "tags")
    public List<Post> posts = new ArrayList<>();

    public String description;

    public Tag() {
    }

    public List<Post> getPosts(){
        return posts;
    }

   public void setPosts(List<Post> posts){
        this.posts = posts;
   }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

}