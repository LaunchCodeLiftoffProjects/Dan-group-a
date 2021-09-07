//package org.launchcode.project.models;
//
//
//
//import org.launchcode.project.data.TagRepository;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.validation.Valid;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Post extends AbstractEntity {
//
//    @Size(max=500, message = "Type of Event too long!")
//    private String typeOfEvent;
//
//    @Valid
//    @NotNull
//    private PostDetails postDetails;
//
//    @ManyToOne
//    @NotNull(message="Tag is required")
//    private Tag tag;
//
//    public Post(String typeOfEvent, PostDetails postDetails) {
//        this.typeOfEvent = typeOfEvent;
//        this.postDetails = postDetails;
//    }
//
//    public Post(){}
//
//    public String getTypeOfEvent(){return typeOfEvent;}
//
//    public void setTypeOfEvent(String typeOfEvent){ this.typeOfEvent = typeOfEvent;}
//
//    public PostDetails getPostDetails(){ return postDetails;}
//
//    public void setPostDetails(PostDetails postDetails){ this.postDetails = postDetails;}
//
//    @Override
//    public String toString(){ return typeOfEvent;}
//}
