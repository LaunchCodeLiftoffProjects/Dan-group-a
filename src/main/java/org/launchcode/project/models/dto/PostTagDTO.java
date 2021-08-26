package org.launchcode.project.models.dto;

import org.launchcode.project.models.Post;
import org.launchcode.project.models.Tag;

public class PostTagDTO {

    private Post post;

    private Tag tag;

    public PostTagDTO(){}

    public Post getPost(){
        return post;
    }

    public void setPost (Post post) {this.post = post;}

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
