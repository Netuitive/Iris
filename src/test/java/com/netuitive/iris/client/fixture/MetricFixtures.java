package com.netuitive.iris.client.fixture;

import com.netuitive.iris.entity.Metric;
import com.netuitive.iris.entity.Sample;
import java.util.Date;

/**
 *
 * @author john.king
 */
public class MetricFixtures {

    public static Metric getMetric(){
        Metric metric = new Metric();
        metric.setId("iris.metric");
        metric.setName("Iris Metric");
        return metric;
    }
    public static Sample getSample(){
        Sample sample = new Sample();
        
        sample.setMetricId("iris.metric");
        sample.setTimestamp(new Date());
        sample.setVal(5.0);
        return sample;
    }
}
