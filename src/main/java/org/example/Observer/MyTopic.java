package org.example.Observer;

import java.util.ArrayList;

public class MyTopic implements Subject {
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();
    private ArrayList<Observer> observers = new ArrayList<>();

    public MyTopic() {}

    public void register (Observer observer) {
        observers.add(observer);
    }
    public void unregister (Observer observer) {
        observers.remove(observer);
    }
    public void notifyObservers () {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    public Object getUpdate (Observer observer) {
        return MUTEX;
    }
    public void postMessage (String message) {}
}
