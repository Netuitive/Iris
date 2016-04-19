package com.netuitive.iris.client.request.element;

import java.time.Duration;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Wither;

/**
 *
 * @author john.king
 */
@Data
@Wither
public class ListEventsRequest {

    String elementId;
    Duration duration;
    Date startTime;
    Date endTime;

    public ListEventsRequest(String elementId) {
        this.elementId = elementId;
    }

    public ListEventsRequest(String elementId, Duration duration, Date startTime, Date endTime) {
        this.elementId = elementId;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
