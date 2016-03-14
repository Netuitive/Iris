package com.netuitive.iris.client.request.element;

import com.netuitive.iris.entity.Tag;
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
public class ListElementsRequest {

    String[] ids;
    String[] name;
    String[] type;
    String[] location;
    List<Tag> tags;
    String[] fields;
    Date startTime;
    Date endTime;

    public ListElementsRequest() {
    }

    public ListElementsRequest(String[] ids, String[] name, String[] type, String[] location, List<Tag> tags, String[] fields, Date startTime, Date endTime) {
        this.ids = ids;
        this.name = name;
        this.type = type;
        this.location = location;
        this.tags = tags;
        this.fields = fields;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    
}
