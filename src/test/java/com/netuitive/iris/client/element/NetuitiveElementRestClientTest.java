package com.netuitive.iris.client.element;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.netuitive.iris.client.fixture.TagFixtures;
import com.netuitive.iris.client.request.element.GetMetricMetaDataRequest;
import com.netuitive.iris.client.request.element.GetMetricResultsRequest;
import com.netuitive.iris.client.request.element.ListElementsRequest;
import com.netuitive.iris.client.request.element.ListEventsRequest;
import com.netuitive.iris.entity.MetricResults;
import com.netuitive.iris.entity.event.ResponseEvent;
import com.netuitive.iris.entity.wrapper.ElementDecorator;
import com.netuitive.iris.entity.wrapper.ElementWrapper;
import com.netuitive.iris.entity.wrapper.ElementsWrapper;
import com.netuitive.iris.entity.wrapper.EventsWrapper;
import com.netuitive.iris.entity.wrapper.MetricDecorator;
import com.netuitive.iris.entity.wrapper.MetricMetaWrapper;
import com.netuitive.iris.entity.wrapper.MetricMetasWrapper;
import com.netuitive.iris.entity.wrapper.MetricResultsWrapper;
import com.netuitive.iris.entity.wrapper.TagWrapper;
import com.netuitive.iris.entity.wrapper.TagsWrapper;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

/**
 *
 * @author john.king
 */
@Test(groups = "experiment", enabled = false)
public class NetuitiveElementRestClientTest{

    private final NetuitiveElementRestClient client = new NetuitiveElementRestClient(System.getProperty("username"), System.getProperty("password"));;

    private String elementId;
    
    private String metricId;
    
    private static final long ELEMENT_CREATION_WAIT_TIME = 1000 * 60 * 7;//7 minutes 

    @Test
    public void testGetElements() throws JsonProcessingException {
        
        Boolean found = checkElements();
        if (!found) {
            try {
                Thread.sleep(ELEMENT_CREATION_WAIT_TIME);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            found = checkElements();
        }
        assertTrue(found);
    }
    
    private Boolean checkElements() {
        ElementsWrapper elements = client.listElements(new ListElementsRequest());
        Boolean found = false;
        if (elements != null && elements.getElements() != null) {
            for (ElementDecorator dec : elements.getElements()) {
                if (dec.getFqn().equals("Iris Element")) {
                    elementId = dec.getId();
                    Iterator<MetricDecorator> iterator = dec.getMetrics().iterator();
                    while (iterator.hasNext()) {
                        MetricDecorator metricDec = iterator.next();
                        if (metricDec.getFqn().equals("iris.metric")) {
                            metricId = metricDec.getId();
                            found = true;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return found;
    }

    @Test(dependsOnMethods = {"testGetElements"})
    public void testGetElement() throws JsonProcessingException {
        ElementWrapper element = client.getElement(elementId);
        assertEquals(element.getElement().getFqn(), "Iris Element");
    }

    @Test(dependsOnMethods = {"testGetElements"})
    public void testListEvents() {
        EventsWrapper events = client.listEvents(new ListEventsRequest(elementId));
        Boolean found = false;
        for (ResponseEvent event : events.getEvents()) {
            if (event.getTitle().equals("Iris Event Title")) {
                assertEquals(event.getEventTags().get("Iris Event Tag Name"),"Iris Event Tag Value");
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test(dependsOnMethods = {"testGetElements"})
    public void testGetMetaDataForMetric() throws JsonProcessingException {
        MetricMetasWrapper metricMetas = client.getMetaDataForMetric(new GetMetricMetaDataRequest(elementId).withMetricFQN("iris.metric"));
        for (MetricMetaWrapper metricMeta : metricMetas.getMetricMeta()) {
            if (metricMeta.getFqn().equals("iris.metric")) {
                assertEquals(metricMeta.getConfiguration().get("sparsedatastrategy"), "None");
                assertEquals(metricMeta.getState().get("baselined"), true);
            }
        }
    }
    @Test(dependsOnMethods = {"testGetElements"})
    public void testGetMetricResults() throws JsonProcessingException{
        MetricResultsWrapper wrapper = client.getMetricResults(new GetMetricResultsRequest(elementId, metricId).withRollup("PT5M"));
        for(MetricResults results : wrapper.getSamples()){
            assertEquals(results.getData().get("actual"), 5.0);
        }
    }
    @Test(dependsOnMethods = {"testGetElements"})
    public void testCreateElementTag(){
        TagWrapper input = new TagWrapper();
        input.setNetuitiveTag(TagFixtures.getElementTagMap());
        TagWrapper output = client.createElementTag(elementId, input);
        assertEquals(output.getNetuitiveTag().get("Iris Element Tag Name"), "Iris Element Tag Value");
    }
    @Test(dependsOnMethods = {"testCreateElementTag"})
    public void testUpdateElementTag(){
        TagWrapper input = new TagWrapper();
        input.setNetuitiveTag(TagFixtures.getUpdatedElementTagMap());
        client.updateElementTag(elementId, "Iris Element Tag Name", input);
    }
    @Test(dependsOnMethods = {"testUpdateElementTag"})
    public void testGetElementTags(){
        TagsWrapper output = client.getElementTags(elementId);
        assertEquals(output.getNetuitiveTags().get("Iris Element Tag Name"), "Iris Element Tag Value1");
    }
    @Test(dependsOnMethods = {"testGetElementTags"})
    public void testDeleteElementTag(){
        client.deleteElementTag(elementId, "Iris Element Tag Name");
    }
    
    @Test(dependsOnMethods = {"testGetElements"})
    public void testCreateMetricTag(){
        TagWrapper input = new TagWrapper();
        input.setNetuitiveTag(TagFixtures.getMetricTagMap());
        TagWrapper output = client.createMetricTag(elementId, metricId, input);
        assertEquals(output.getNetuitiveTag().get("Iris Metric Tag Name"), "Iris Metric Tag Value");
    }
    @Test(dependsOnMethods = {"testCreateMetricTag"})
    public void testUpdateMetricTag(){
        TagWrapper input = new TagWrapper();
        input.setNetuitiveTag(TagFixtures.getUpdatedMetricTagMap());
        client.updateMetricTag(elementId, metricId, "Iris Metric Tag Name", input);
    }
    @Test(dependsOnMethods = {"testUpdateMetricTag"})
    public void testGetMetricTags(){
        TagsWrapper output = client.getMetricTags(elementId, metricId);
        assertEquals(output.getNetuitiveTags().get("Iris Metric Tag Name"), "Iris Metric Tag Value1");
    }
    @Test(dependsOnMethods = {"testGetMetricTags"})
    public void testDeleteMetricTag(){
        client.deleteMetricTag(elementId, metricId, "Iris Metric Tag Name");
    }
    
}
