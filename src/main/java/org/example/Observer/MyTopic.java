package org.example.Observer;

public class MyTopic {
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();
    private Observer[] observers;

    public MyTopic() {}

    public void register (Observer observer) {}
    public void unregister (Observer observer) {}
    public void notifyObservers () {}
    public Object getUpdate (Observer observer) {
        return MUTEX;
    }
    public void postMessage (String message) {}
}
