package org.launchcode.project.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag extends AbstractEntity{

    @Size(min = 3)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private final List<Post> posts = new ArrayList<>();

    public Tag() {}

    public Tag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts; }

}