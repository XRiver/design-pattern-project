package nju.riverxu.ds.util;

public interface Observer {
    void notifyEvent(EventType eventType, Object event);
}
