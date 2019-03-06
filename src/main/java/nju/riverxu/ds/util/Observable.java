package nju.riverxu.ds.util;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyAll(EventType eventType, Object event);
}
