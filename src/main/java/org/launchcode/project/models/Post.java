package org.launchcode.project.models;

public class Post {

    private String event;

    public Post(String event){
        this.event = event;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return event;
    }
}
