<<<<<<< HEAD:src/main/java/org/launchcode/project/models/dto/EventTagDTO.java
//package org.launchcode.project.models.dto;
//
//import org.launchcode.project.models.Post;
//import org.launchcode.project.models.Tag;
//
//import javax.validation.constraints.NotNull;
//
//public class EventTagDTO {
//
//    @NotNull
//    private Post post;
//
//    @NotNull
//    private Tag tag;
//
//    public EventTagDTO() {}
//
//    public Post getPost() {
//        return post;
//    }
//
//    public void setPost(Post post) {
//        this.post = post;
//    }
//
//    public Tag getTag() {
//        return tag;
//    }
//
//    public void setTag(Tag tag) {
//        this.tag = tag;
//    }
//}
=======
package org.launchcode.project.models.DTO;

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
>>>>>>> main:src/main/java/org/launchcode/project/models/DTO/PostTagDTO.java
