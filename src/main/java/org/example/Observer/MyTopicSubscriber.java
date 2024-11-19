package org.example.Observer;

import java.util.ArrayList;

public class MyTopicSubscriber implements Observer {
    private String name;
    private ArrayList topic;
    public MyTopicSubscriber(String name) {
        this.name = name;
    }

    public void update() {}

    public void setSubject(Subject subject) {}


}
