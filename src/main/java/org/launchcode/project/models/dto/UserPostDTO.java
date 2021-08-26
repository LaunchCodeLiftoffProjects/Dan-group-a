package org.launchcode.project.models.dto;

import org.launchcode.project.models.Post;
import org.launchcode.project.models.User;

public class UserPostDTO {

    private User user;

    private Post post;

    public UserPostDTO(){
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
