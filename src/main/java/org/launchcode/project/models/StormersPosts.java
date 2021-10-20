package org.launchcode.project.models;

import org.launchcode.project.data.FileUploadServlet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StormersPosts {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String description;
    private String postCategory;
    private FileUploadServlet image;


    public StormersPosts(String name, String description, String postCategory, FileUploadServlet image) {
        this.name = name;
        this.description = description;
        this.postCategory = postCategory;
        this.image = image;

    }

    public StormersPosts() {
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

    public FileUploadServlet getImage() {
        return image;
    }

    public void setImage(FileUploadServlet image) {
        this.image = image;
    }

    public void setPostCategory(String postCategory) {
        this.postCategory = postCategory;
    }
    @Override
    public String toString() {
        return name;
    }



}
