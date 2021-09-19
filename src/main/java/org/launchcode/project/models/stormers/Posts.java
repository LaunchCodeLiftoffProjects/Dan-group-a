package org.launchcode.project.models.stormers;

public class Posts {


    private int id;
    private static int nextId = 1;


    private String name;
    private String description;
    private String postCategory;


    public Posts(String name, String description, String postCategory) {
        this.name = name;
        this.description = description;
        this.postCategory = postCategory;
        this.id=nextId;
        nextId++;
    }

    public int getId() {
        return id;
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
    @Override
    public String toString() {
        return name;
    }



}
