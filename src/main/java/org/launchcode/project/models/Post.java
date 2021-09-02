package org.launchcode.project.models;
import org.launchcode.project.models.Tag;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post extends AbstractEntity {


    private String name;

    @ManyToMany
    private final List<Tag> tags = new ArrayList<>();

    @ManyToOne
//    @JoinColumn(name="user", nullable=false)
    private User user;

    public Post(){}

    public Post(String name){
        this.name=name;
    }

    public void addTag(Tag tag){
        tags.add(tag);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tag> getTags(){
        return tags;
    }


}
