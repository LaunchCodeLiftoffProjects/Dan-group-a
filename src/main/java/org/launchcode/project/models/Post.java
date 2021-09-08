package org.launchcode.project.models;
import org.launchcode.project.data.TagRepository;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post extends AbstractEntity {

    @Size(max=500, message = "Type of Event too long!")
    @NotNull
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private PostDetails postDetails;

    @ManyToMany
    private final List<Tag> tags = new ArrayList<>();

    public Post(String name) {
        this.name = name;
    }

    public Post(){}

    public String getName(){ return name;}

    public void setName(String name){ this.name = name;}

    public PostDetails getPostDetails(){ return postDetails;}

    public void setPostDetails(PostDetails postDetails){ this.postDetails = postDetails;}

    public List<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    @Override
    public String toString(){ return name;}
}
