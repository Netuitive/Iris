package com.netuitive.iris.client.fixture;

import com.netuitive.iris.entity.Tag;
import com.netuitive.iris.entity.event.EventType;
import com.netuitive.iris.entity.event.ingest.IngestEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author john.king
 */
public class EventFixtures {

    public static IngestEvent getIngestEvent(){
        IngestEvent event = new IngestEvent();
        Map<String, String> data = new HashMap<String, String>();
        data.put("elementId", "Iris Element");
        data.put("level", "WARNING");
        data.put("message", "Iris Event Message");
        event.setData(data);
        event.setSource("Iris Event Source");
        Set<Tag> tags = new HashSet<Tag>();
        tags.add(TagFixtures.getEventTag());
        event.setTags(tags);
        event.setType(EventType.INFO);
        event.setTitle("Iris Event Title");
        event.setTimestamp(new Date());
        return event;
    }
}
