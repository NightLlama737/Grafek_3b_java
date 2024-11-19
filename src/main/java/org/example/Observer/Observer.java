package org.example.Observer;

import java.util.Observable;

public interface Observer {
    public void update() ;
    public void setSubject(Subject subject);
}
