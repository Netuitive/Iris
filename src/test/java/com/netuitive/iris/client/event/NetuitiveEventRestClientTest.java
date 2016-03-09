package com.netuitive.iris.client.event;

import com.netuitive.iris.client.fixture.EventFixtures;
import com.netuitive.iris.client.request.event.GetEventsRequest;
import com.netuitive.iris.entity.event.ResponseEvent;
import com.netuitive.iris.entity.event.ingest.IngestEvent;
import com.netuitive.iris.entity.wrapper.EventWrapper;
import com.netuitive.iris.entity.wrapper.EventsWrapper;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

/**
 *
 * @author john.king
 */
@Test(groups = "unit")
public class NetuitiveEventRestClientTest{
    
    private final NetuitiveEventRestClient client = new NetuitiveEventRestClient(System.getProperty("username"), System.getProperty("password"));;
    
    private final NetuitiveIngestEventRestClient ingestClient = new NetuitiveIngestEventRestClient(System.getProperty("apiKey"));
    
    String eventId;
    
    @Test
    public void testIngest(){
        List<IngestEvent> events = new ArrayList<IngestEvent>();
        events.add(EventFixtures.getIngestEvent());
        ingestClient.ingest(events);
        //look for error response
    }
    
    @Test(dependsOnMethods = {"testIngest"})
    public void testGetEvents(){
        EventsWrapper wrapper = client.getEvents(new GetEventsRequest());
        Boolean found = false;
        for(ResponseEvent event : wrapper.getEvents()){
            if(event.getIsExternal() && event.getTitle().equals("Iris Event Title")){
                found = true;
                eventId = event.getId();
                break;
            }
        }
        assertTrue(found);
    }
    
    @Test(dependsOnMethods = {"testGetEvents"})
    public void testGetEvent(){
        EventWrapper event = client.getEvent(eventId);
        assertEquals(event.getEvent().getTitle(), "Iris Event Title");
    }
}
