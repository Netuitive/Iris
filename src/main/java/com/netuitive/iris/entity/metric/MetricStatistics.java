package com.netuitive.iris.entity.metric;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 *
 * @author john.king
 */
@Data
public class MetricStatistics {

    private String elementId;
    private String metricId;
    private Map<String, Double> statistics = new HashMap<String, Double>();
    private List<Double> data;
}
