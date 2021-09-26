package org.launchcode.project.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post extends AbstractEntity {

    @ManyToOne
    public User user;

    @ManyToMany
    public List<Tag>tags = new ArrayList<>();

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    public String name;

    public Post(){}

    public Post(User anUser, List<Tag> someTags){
        super();
        this.user = user;
        this.tags = someTags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags){
        this.tags = tags;
    }
    public void addTag(Tag tag){
        this.tags.add(tag);
    }

    @Override
    public String toString() {
        return name;
    }



}
