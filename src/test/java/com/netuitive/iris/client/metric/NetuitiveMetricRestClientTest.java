package com.netuitive.iris.client.metric;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.netuitive.iris.client.fixture.ElementFixtures;
import com.netuitive.iris.client.request.metric.GetMetricFqnsRequest;
import com.netuitive.iris.client.request.metric.GetMetricStatisticsRequest;
import com.netuitive.iris.client.request.metric.IngestRequest;
import com.netuitive.iris.entity.Element;
import com.netuitive.iris.entity.metric.MetricStatistics;
import com.netuitive.iris.entity.wrapper.FqnListWrapper;
import com.netuitive.iris.entity.wrapper.MetricStatisticsWrapper;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

/**
 *
 * @author john.king
 */
@Test(groups = "unit")
public class NetuitiveMetricRestClientTest{

    private final NetuitiveMetricRestClient client = new NetuitiveMetricRestClient(System.getProperty("username"), System.getProperty("password"));

    private final NetuitiveIngestMetricRestClient ingestClient = new NetuitiveIngestMetricRestClient(System.getProperty("apiKey"));;

    @Test
    public void testIngest() throws JsonProcessingException {
        List<Element> elements = new ArrayList<Element>();
        elements.add(ElementFixtures.getElement());
        ingestClient.ingest(new IngestRequest(elements));
    }
    
    @Test(dependsOnMethods = {"testIngest"})
    public void testGetFqns() throws JsonProcessingException{
        GetMetricFqnsRequest req = new GetMetricFqnsRequest()
                .withElementType("Iris Type")
                .withElementFqn("Iris Element")
                .withMetricFqn("iris.metric");
        FqnListWrapper wrapper = client.getMetricFqns(req);
        Boolean found = false;
        int count = 0;
        for(String fqn : wrapper.getFqns()){
            count++;
            if(fqn.equals("iris.metric")){
                found = true;
            }
        }
        assertEquals(count, 1);
        assertTrue(found);
    }
    @Test(dependsOnMethods = {"testIngest"})
    public void testGetMetricStatistics(){
        MetricStatisticsWrapper wrapper = client.getMetricStatistics(new GetMetricStatisticsRequest("iris.metric"));
        for (MetricStatistics stats : wrapper.getMetrics()){
            assertEquals(stats.getStatistics().get("avg"), 5.0);
            assertEquals(stats.getStatistics().get("min"), 5.0);
            assertEquals(stats.getStatistics().get("max"), 5.0);
        }
    }
}
