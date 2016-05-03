package com.netuitive.iris.scheduler;

import com.netuitive.iris.cache.ElementCache;
import com.netuitive.iris.client.metric.NetuitiveIngestMetricClient;
import com.netuitive.iris.client.metric.NetuitiveIngestMetricRestClient;
import com.netuitive.iris.client.request.metric.IngestRequest;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 *
 * @author john.king
 */
public class IngestScheduler extends Scheduler{

    final ElementCache cache;
    
    private final NetuitiveIngestMetricClient client;
    
    public IngestScheduler(String apiKey){
        this(new ElementCache(), new NetuitiveIngestMetricRestClient(apiKey));
    }
    
    public IngestScheduler(ElementCache cache, NetuitiveIngestMetricClient client){
        this.cache = cache;
        this.client = client;
    }
    
    public ElementCache getCache(){
        return cache;
    }

    @Override
    public void doJob() {
        client.ingest(new IngestRequest(cache.clear()));
    }
}
