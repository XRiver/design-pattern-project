package nju.riverxu.ds.model;

import nju.riverxu.ds.util.Observable;

public interface LogManager extends Observable {
    void addLog(LogType type,String content);
}
