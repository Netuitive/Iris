package com.netuitive.iris.entity.event.ingest;

import com.netuitive.iris.entity.Tag;
import com.netuitive.iris.entity.event.EventType;
import lombok.Data;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @author John King
 */
@Data
public class IngestEvent {

    private String source;
    private Date timestamp;
    private String title;
    private Set<Tag> tags;
    private EventType type;
    private Map<String, String> data;
}
