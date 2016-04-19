package com.netuitive.iris.client.event;

import com.netuitive.iris.client.BasicAuthRestClient;
import com.netuitive.iris.client.request.GenericRequest;
import com.netuitive.iris.client.request.event.GetEventsRequest;
import com.netuitive.iris.client.utils.HttpMethod;
import com.netuitive.iris.entity.wrapper.EventWrapper;
import com.netuitive.iris.entity.wrapper.EventsWrapper;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author john.king
 */
public class NetuitiveEventRestClient extends BasicAuthRestClient implements NetuitiveEventClient {

    public static final String EVENTS_ENDPOINT = "/events";

    public NetuitiveEventRestClient(String username, String password) {
        super(username, password);
    }

    @Override
    public EventWrapper getEvent(String eventId) {
        String path = EVENTS_ENDPOINT + "/" + eventId;
        return this.send(new GenericRequest(HttpMethod.GET, path)
                .withReturnType(EventWrapper.class));
    }

    @Override
    public EventsWrapper getEvents(GetEventsRequest req) {
        String path = EVENTS_ENDPOINT + "/";
        Map<String, Object> params = new HashMap<String, Object>();
        if (req.getDuration() != null) {
            params.put("duration", req.getDuration());
        }
        if (req.getEndTime() != null) {
            params.put("endTime", req.getEndTime().getTime());
        }
        if (req.getStartTime() != null) {
            params.put("startTime", req.getStartTime().getTime());
        }
        if (req.getIsExternal() != null) {
            params.put("isExternal", req.getIsExternal());
        }
        if (req.getCategory() != null) {
            params.put("category", req.getCategory());
        }
        if (req.getElementId() != null) {
            params.put("elementId", req.getElementId());
        }
        if (req.getElementName() != null) {
            params.put("elementName", req.getElementName());
        }
        if (req.getElementTags() != null) {
            params.put("tags", req.getElementTags());
        }
        if (req.getElementType() != null) {
            params.put("elementType", req.getElementType());
        }
        if (req.getPolicy() != null) {
            params.put("policy", req.getPolicy());
        }
        if (req.getTitle() != null) {
            params.put("title", req.getTitle());
        }
        if (req.getType() != null) {
            params.put("type", req.getType());
        }
        return this.send(new GenericRequest(HttpMethod.GET, path)
                .withReturnType(EventsWrapper.class)
                .withParams(params));

    }

}
