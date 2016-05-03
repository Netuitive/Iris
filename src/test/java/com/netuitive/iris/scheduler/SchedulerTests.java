package com.netuitive.iris.scheduler;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author john.king
 */
@Test(groups = "unit")
public class SchedulerTests {

    private int hitCount;
    private Scheduler scheduler;
    public static final int SCHEDULE_SECONDS = 10;
    
    @BeforeTest
    public void init(){
        scheduler = new TestScheduler();
        hitCount = 0;
    }
    
    @Test
    public void testSchedule() throws InterruptedException{
        scheduler.start(SCHEDULE_SECONDS);
        Thread.sleep((SCHEDULE_SECONDS + 2) * 1000);
        assertTrue(hitCount == 1);
        Thread.sleep((SCHEDULE_SECONDS + 2) * 1000);
        assertTrue(hitCount == 2);
    }
    
    @Test(dependsOnMethods = {"testSchedule"})
    public void testStopSchedule() throws InterruptedException{
        scheduler.stop();
        hitCount = 0;
        Thread.sleep((SCHEDULE_SECONDS + 2) * 1000);
        assertTrue(hitCount == 0);
        assertTrue(scheduler.isDone());
    }
    
    private class TestScheduler extends Scheduler{

        @Override
        public void doJob() {
            hitCount++;
        }
        
    }
}
