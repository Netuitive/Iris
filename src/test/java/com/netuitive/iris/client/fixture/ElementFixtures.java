package com.netuitive.iris.client.fixture;

import com.netuitive.iris.entity.Element;
import com.netuitive.iris.entity.Metric;
import com.netuitive.iris.entity.Sample;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 *
 * @author john.king
 */
public class ElementFixtures {

    public static Element getElement(){
        Element element = new Element();
        element.setName("Iris Element");
        element.setId("Iris Element");
        element.setType("Iris Type");
        Set<Metric> metrics = new HashSet<Metric>();
        metrics.add(MetricFixtures.getMetric());
        element.setMetrics(metrics);
        Set<Sample> samples = new HashSet<Sample>();
        samples.add(MetricFixtures.getSample());
        element.setSamples(samples);
        return element;
    }
}
