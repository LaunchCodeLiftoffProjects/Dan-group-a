package org.launchcode.project.models;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity{

    @NotNull
    private String name;

//    @OneToMany(mappedBy = "post")
//    private final List<UserPost>userPosts = new ArrayList<>();

    public void User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
