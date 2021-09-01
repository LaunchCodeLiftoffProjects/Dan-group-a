package org.launchcode.project.models;
import org.launchcode.project.models.Tag;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post extends AbstractEntity {

    @ManyToMany
    private final List<Tag> tags = new ArrayList<>();

    public Post(){}

    public void addTag(Tag tag){
        tags.add(tag);
    }

    public List<Tag> getTags(){
        return tags;
    }


}
