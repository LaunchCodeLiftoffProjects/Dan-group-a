package org.launchcode.project.models;



import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Entity
public class StormersPosts {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String description;
    private String postCategory;

    @Column(nullable = true, length = 64)
    private String photos;


    public StormersPosts(String name, String description, String postCategory,String photos) {

        this.name = name;
        this.description = description;
        this.postCategory = postCategory;
        this.photos = photos;
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

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    @Transient
    public String getPhotosImagePath() {
        if (photos == null || id == 0) return null;

        return "/newPost-photos/" + id + "/" + photos;
    }


    public void setPostCategory(String postCategory) {
        this.postCategory = postCategory;
    }
    @Override
    public String toString() {
        return name;
    }



}
