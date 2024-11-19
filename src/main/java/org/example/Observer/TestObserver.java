package org.example.Observer;

import com.google.inject.Inject;

public class TestObserver {

    public static void main(String[] args) {
        MyTopic myTopic = new MyTopic();

        Observer observer1 = new MyTopicSubscriber("Filip");
        Observer observer2 = new MyTopicSubscriber("Erik");
        Observer observer3 = new MyTopicSubscriber("Ondra");
        myTopic.register(observer1);
        myTopic.register(observer1);
        myTopic.register(observer2);
        myTopic.register(observer3);
        myTopic.postMessage("Byl jsi registrován");
        myTopic.postMessage("Byl jsi registrován");




    }



}
