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
public class GetMetricResultsRequest {

    String elementId;
    String metricId;
    Duration duration;
    Date startTime;
    Date endTime;
    String rollup;

    public GetMetricResultsRequest(String elementId, String metricId) {
        this.elementId = elementId;
        this.metricId = metricId;
    }

    public GetMetricResultsRequest(String elementId, String metricId, Duration duration, Date startTime, Date endTime, String rollup) {
        this.elementId = elementId;
        this.metricId = metricId;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.rollup = rollup;
    }
    
    
}
