package com.netuitive.iris.entity.wrapper;

import com.netuitive.iris.entity.TimeSpan;
import com.netuitive.iris.entity.metric.MetricStatistics;
import lombok.Data;

/**
 *
 * @author john.king
 */
@Data
public class MetricStatisticsWrapper {

    private String metricFqn;
    private TimeSpan timeSpan;
    private Iterable<MetricStatistics> metrics;
}
