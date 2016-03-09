package com.netuitive.iris.client.request.metric;

import com.netuitive.iris.entity.Element;
import java.util.List;
import lombok.Data;
import lombok.experimental.Wither;

/**
 *
 * @author john.king
 */
@Data
@Wither
public class IngestRequest {

    List<Element> ingestElements;
    String apiOptions;

    public IngestRequest(List<Element> ingestElements) {
        this.ingestElements = ingestElements;
    }

    public IngestRequest(List<Element> ingestElements, String apiOptions) {
        this.ingestElements = ingestElements;
        this.apiOptions = apiOptions;
    }
}
