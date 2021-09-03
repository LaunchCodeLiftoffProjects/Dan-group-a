package org.launchcode.project.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class PostDetails extends AbstractEntity {

    @Size(max = 500, message = "Description too long!")
    private String description;

    public PostDetails(String description) {
        this.description = description;
    }

    public PostDetails (){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
