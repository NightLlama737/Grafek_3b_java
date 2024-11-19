package org.example.Observer;

public class MyTopicSubscriber implements Observer {
    private String name;
    private Subject topic;
    public MyTopicSubscriber(String name) {
        this.name = name;
    }
    @Override
    public void update() {}

    public void setSubject(Subject subject) {}


}
