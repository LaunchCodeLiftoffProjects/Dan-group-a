

package org.launchcode.project.models.dto;

import org.launchcode.project.models.Post;
import org.launchcode.project.models.Tag;

import javax.validation.constraints.NotNull;

public class PostTagDTO {

    @NotNull
    private Post post;

    @NotNull
    private Tag tag;

    public PostTagDTO(){}

    public Post getPost(){
        return post;
    }

    public void setPost(Post post){
        this.post = post;
    }

    public Tag getTag(){
        return tag;
    }

    public void setTag(Tag tag){
        this.tag=tag;
    }


}
