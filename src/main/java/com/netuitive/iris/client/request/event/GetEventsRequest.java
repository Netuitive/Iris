package com.netuitive.iris.client.request.event;

import com.netuitive.iris.entity.Tag;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.experimental.Wither;

/**
 *
 * @author john.king
 */
@Data
@Wither
public class GetEventsRequest {

    Duration duration;
    Date startTime;
    Date endTime;
    String[] category;
    String[] elementId;
    String[] elementName;
    String[] elementType;
    List<Tag> elementTags;
    String[] policy;
    Boolean isExternal;
    String[] title;
    String[] type;

    public GetEventsRequest() {
    }

    public GetEventsRequest(Duration duration, Date startTime, Date endTime, String[] category, String[] elementId, String[] elementName, String[] elementType, List<Tag> elementTags, String[] policy, Boolean isExternal, String[] title, String[] type) {
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.category = category;
        this.elementId = elementId;
        this.elementName = elementName;
        this.elementType = elementType;
        this.elementTags = elementTags;
        this.policy = policy;
        this.isExternal = isExternal;
        this.title = title;
        this.type = type;
    }
    
    
}
