package nju.riverxu.ds.model.tour;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tour {
    private ExecutorService spiritThreadPool = Executors.newCachedThreadPool();
    private Dungeon current;

}
