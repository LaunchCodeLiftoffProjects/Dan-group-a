package org.launchcode.project.models.stormers;

public class Posts {

    private String name;
    private String description;
    private String postCategory;

    public Posts(String name, String description, String postCategory) {
        this.name = name;
        this.description = description;
        this.postCategory = postCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(String postCategory) {
        this.postCategory = postCategory;
    }
}
