package org.example.Observer;

import jakarta.inject.Singleton;

import java.util.ArrayList;
@Singleton
public class MyTopic implements Subject {
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();
    private ArrayList<Observer> observers = new ArrayList<>();

    public MyTopic() {}

    public void register (Observer observer) {
        if (!observers.contains(observer)) {
            observer.setSubject(this);
            observers.add(observer);
        }

    }
    public void unregister (Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
            observer.setSubject(null);

        }
    }
    public void notifyObservers () {
        if (!changed) {
            return;
        }
        changed = false;
        for (Observer observer : observers) {
            observer.update();
        }
    }
    public Object getUpdate (Observer observer) {
        return message;
    }
    public void postMessage (String message) {
        this.message = message;
        changed = true;
        notifyObservers();
    }
}
