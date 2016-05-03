package com.netuitive.iris.scheduler;

import com.netuitive.iris.cache.ElementCache;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 *
 * @author john.king
 */
public abstract class Scheduler {
    
    private ScheduledFuture jobHandle;

    public abstract void doJob();
    
    private final ScheduledExecutorService scheduler =
        Executors.newSingleThreadScheduledExecutor();
    
    final Runnable job = new Runnable() {
       public void run() { 
           doJob();
       }
     };
    
    public void start(int intervalSeconds){
        jobHandle = scheduler.scheduleAtFixedRate(job, intervalSeconds, intervalSeconds, SECONDS);
    }
    
    public void stop(){
        jobHandle.cancel(false);
    }
    
    public Boolean isDone(){
        return jobHandle.isDone();
    }
    
    public Boolean isCancelled(){
        return jobHandle.isCancelled();
    }
}
