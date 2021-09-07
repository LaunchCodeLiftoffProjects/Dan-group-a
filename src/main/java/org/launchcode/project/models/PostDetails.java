package org.launchcode.project.models;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class PostDetails extends AbstractEntity {

    @Size(max=500, message="Description too long!")
    private String description;

    public PostDetails(String description){
        this.description = description;
    }

    public PostDetails(){}

    public String getDescription(String description){
        return description;
    }

}
