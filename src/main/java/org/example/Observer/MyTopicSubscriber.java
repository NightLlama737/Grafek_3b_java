package org.example.Observer;

import java.util.ArrayList;

public class MyTopicSubscriber implements Observer {
    private String name;
    private Subject topic;
    public MyTopicSubscriber(String name) {
        this.name = name;
    }

    public void update() {
        System.out.println(topic.getUpdate(this));
    }

    public void setSubject(Subject subject) {
        this.topic = subject;
    }

}
