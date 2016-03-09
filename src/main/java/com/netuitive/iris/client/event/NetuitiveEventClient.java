package com.netuitive.iris.client.event;

import com.netuitive.iris.client.request.event.GetEventsRequest;
import com.netuitive.iris.entity.wrapper.EventWrapper;
import com.netuitive.iris.entity.wrapper.EventsWrapper;

/**
 *
 * @author john.king
 */
public interface NetuitiveEventClient {
    public EventWrapper getEvent(String eventId);
    public EventsWrapper getEvents(GetEventsRequest req);
}
