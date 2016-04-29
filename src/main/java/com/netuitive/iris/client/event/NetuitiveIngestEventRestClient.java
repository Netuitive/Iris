package com.netuitive.iris.client.event;

import com.netuitive.iris.client.APIKeyRestClient;
import com.netuitive.iris.client.request.GenericRequest;
import com.netuitive.iris.client.utils.HttpMethod;
import com.netuitive.iris.entity.event.ingest.IngestEvent;
import java.util.List;

/**
 *
 * @author john.king
 */
public class NetuitiveIngestEventRestClient extends APIKeyRestClient implements NetuitiveIngestEventClient {

    public static final String INGEST_EVENTS_ENDPOINT = "/ingest/events";

    public NetuitiveIngestEventRestClient(String apiKey) {
        super(apiKey);
    }
    
    public NetuitiveIngestEventRestClient(String scheme, String host, String apiKey) {
        super(scheme, host, apiKey);
    }

    @Override
    public void ingest(List<IngestEvent> events) {
        String path = INGEST_EVENTS_ENDPOINT + "/" + this.getApiKey();
        this.send(new GenericRequest(HttpMethod.POST, path)
                .withBody(events));
    }

}
