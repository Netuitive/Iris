package com.netuitive.iris.entity;

import java.util.Date;
import java.util.Map;
import lombok.Data;

/**
 *
 * @author john.king
 */
@Data
public class MetricResults {
    
    private String metricId;
    private Date timestamp;
    private String rollup;
    private Map<String,Object> data;
}
