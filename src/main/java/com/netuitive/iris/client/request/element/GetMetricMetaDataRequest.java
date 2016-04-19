package com.netuitive.iris.client.request.element;

import lombok.Data;
import lombok.experimental.Wither;

/**
 *
 * @author john.king
 */
@Data
@Wither
public class GetMetricMetaDataRequest {

    String elementId;
    String metricFQN;

    public GetMetricMetaDataRequest(String elementId) {
        this.elementId = elementId;
    }

    public GetMetricMetaDataRequest(String elementId, String metricFQN) {
        this.elementId = elementId;
        this.metricFQN = metricFQN;
    }
}
