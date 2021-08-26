package org.launchcode.project.models;
import org.launchcode.project.models.Tag;

public class Post {

    private Tag tag;

    public Post() {
        this.tag = tag;
    }

    public String addTag(Tag tag){
        this.tag=tag;
    }

    public Tag getTag() {
        return tag;
    }
}
