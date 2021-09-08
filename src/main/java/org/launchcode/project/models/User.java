package org.launchcode.project.models;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity{

//    @OneToMany(mappedBy = "post")
//    private final List<UserPost>userPosts = new ArrayList<>();

    public void User(){}

}
