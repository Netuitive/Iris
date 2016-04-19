package com.netuitive.iris.client.metric;

import com.netuitive.iris.client.request.metric.GetMetricFqnsRequest;
import com.netuitive.iris.client.request.metric.GetMetricStatisticsRequest;
import com.netuitive.iris.entity.wrapper.FqnListWrapper;
import com.netuitive.iris.entity.wrapper.MetricStatisticsWrapper;

/**
 *
 * @author john.king
 */
public interface NetuitiveMetricClient {
    public MetricStatisticsWrapper getMetricStatistics(GetMetricStatisticsRequest req);
    public FqnListWrapper getMetricFqns(GetMetricFqnsRequest req);
}
