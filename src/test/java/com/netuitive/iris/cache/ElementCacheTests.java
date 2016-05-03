package com.netuitive.iris.cache;

import com.netuitive.iris.client.fixture.ElementFixtures;
import com.netuitive.iris.entity.Element;
import com.netuitive.iris.entity.Metric;
import com.netuitive.iris.entity.Sample;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author john.king
 */
@Test(groups = "unit")
public class ElementCacheTests {

    ElementCache cache;
    @BeforeTest
    public void init(){
        cache = new ElementCache();
    }
    @Test
    public void testMerge() throws InterruptedException{
        cache.addElement(ElementFixtures.getElement());
        Thread.sleep(3);//to get a different timstamp to avoid hash collisions
        cache.addElement(ElementFixtures.getElement());
        List<Element> elements = cache.getElements();
        assertEquals(elements.size(), 1);
        Element element = elements.get(0);
        assertEquals(element.getId(), "Iris Element");
        assertEquals(element.getMetrics().size(), 1);
        Metric metric = (Metric) element.getMetrics().toArray()[0];
        assertEquals(metric.getId(), "iris.metric");
        assertEquals(element.getSamples().size(), 2);
        Sample sample = (Sample) element.getSamples().toArray()[0];
        assertEquals(sample.getMetricId(), "iris.metric");
    }
}
