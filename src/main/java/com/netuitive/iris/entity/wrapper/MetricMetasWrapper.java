package com.netuitive.iris.entity.wrapper;

import lombok.Data;

/**
 *
 * @author john.king
 */
@Data
public class MetricMetasWrapper {

    private String id;
    private Iterable<MetricMetaWrapper> metricMeta;
}
