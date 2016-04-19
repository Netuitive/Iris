package com.netuitive.iris.entity.Policy;

import lombok.Data;

/**
 *
 * @author john.king
 */
@Data
public class PolicyCondition {

    private String metric;
    private String wildcard;
    private PolicyConditionAnalytic analytic;
    private String operator;
    private Double level;
}
