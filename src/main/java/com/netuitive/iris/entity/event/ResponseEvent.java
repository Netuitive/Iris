package com.netuitive.iris.entity.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.netuitive.iris.entity.Policy.Policy;
import com.netuitive.iris.entity.ResponseTag;
import com.netuitive.iris.entity.Tag;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 *
 * @author john.king
 */
@Data
public class ResponseEvent {

    private String id;

    private Date timestamp;

    private EventCategory category;

    private Map<String, Object> data;

    private String elementId;

    private String elementFqn;

    private String elementType;

    private String elementName;

    private String elementLocation;

    private Map<String, Object> elementTags;
    
    private Map<String, Object> eventTags;

    private Policy policy;

    private String source;

    private String title;

    private Set<ResponseTag> tags;

    private EventType type;
    
    private Boolean isExternal;
    
    private Date processedTime;
}
