package com.netuitive.iris.client.request.metric;

import com.netuitive.iris.entity.Tag;
import java.util.List;
import lombok.Data;
import lombok.experimental.Wither;

/**
 *
 * @author john.king
 */
@Data
@Wither
public class GetMetricFqnsRequest {

    String elementId;
    String elementFqn;
    String elementName;
    String elementType;
    String elementAttribute;
    List<Tag> elementTag;
    String metricFqn;
    List<Tag> metricTag;

    public GetMetricFqnsRequest() {
    }

    public GetMetricFqnsRequest(String elementId, String elementFqn, String elementName, String elementType, String elementAttribute, List<Tag> elementTag, String metricFqn, List<Tag> metricTag) {
        this.elementId = elementId;
        this.elementFqn = elementFqn;
        this.elementName = elementName;
        this.elementType = elementType;
        this.elementAttribute = elementAttribute;
        this.elementTag = elementTag;
        this.metricFqn = metricFqn;
        this.metricTag = metricTag;
    }

    
    
}
