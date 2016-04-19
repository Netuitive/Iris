package com.netuitive.iris.client.request.metric;

import com.netuitive.iris.entity.MetricResultsRollup;
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
public class GetMetricStatisticsRequest {

    String fqn;

    Duration duration;
    Date startTime;
    Date endTime;
    MetricResultsRollup[] rollup;
    Boolean showValues;

    public GetMetricStatisticsRequest(String fqn) {
        this.fqn = fqn;
    }

    public GetMetricStatisticsRequest(String fqn, Duration duration, Date startTime, Date endTime, MetricResultsRollup[] rollup, Boolean showValues) {
        this.fqn = fqn;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.rollup = rollup;
        this.showValues = showValues;
    }
    
    
}
