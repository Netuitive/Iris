package com.netuitive.iris.client.metric;

import com.netuitive.iris.client.APIKeyRestClient;
import com.netuitive.iris.client.request.GenericRequest;
import com.netuitive.iris.client.request.metric.IngestRequest;
import com.netuitive.iris.client.utils.HttpMethod;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author john.king
 */
public class NetuitiveIngestMetricRestClient extends APIKeyRestClient implements NetuitiveIngestMetricClient{

    public static final String INGEST_ENDPOINT = "/ingest";
    
    public NetuitiveIngestMetricRestClient(String apiKey) {
        super(apiKey);
    }

    @Override
    public void ingest(IngestRequest req) {
        String path = INGEST_ENDPOINT + "/" + this.getApiKey();
        Map<String, String> headers = new HashMap<String,String>();
        if(req.getApiOptions() != null){
            headers.put("X-Netuitive-Api-Options", req.getApiOptions());
        }
        this.send(new GenericRequest(HttpMethod.POST, path)
        .withBody(req.getIngestElements())
        .withHeaders(headers));
    }

}
