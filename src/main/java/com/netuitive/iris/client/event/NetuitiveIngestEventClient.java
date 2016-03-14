package com.netuitive.iris.client.event;

import com.netuitive.iris.entity.event.ingest.IngestEvent;
import java.util.List;

/**
 *
 * @author john.king
 */
public interface NetuitiveIngestEventClient {
    public void ingest( List<IngestEvent> events);
}
