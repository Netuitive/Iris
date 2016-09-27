package com.netuitive.iris.entity.Policy;

import java.util.Map;
import lombok.Data;

/**
 *
 * @author john.king
 */
@Data
public class PolicyCondition {

    private String metric;
    private String wildcard;
    private Map<String, String> metricScopeTags;
    private PolicyConditionAnalytic analytic;
    private String operator;
    private Double level;
    private Double level2;
    private String metricThresholdLevel;
    private String metricThresholdAnalytic;

}
