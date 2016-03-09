package com.netuitive.iris.client.metric;

import com.netuitive.iris.client.request.metric.IngestRequest;

/**
 *
 * @author john.king
 */
public interface NetuitiveIngestMetricClient {
    public void ingest(IngestRequest req);
}
