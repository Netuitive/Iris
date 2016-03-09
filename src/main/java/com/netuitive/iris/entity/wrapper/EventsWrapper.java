package com.netuitive.iris.entity.wrapper;

import com.netuitive.iris.entity.event.ResponseEvent;
import lombok.Data;

/**
 *
 * @author john.king
 */
@Data
public class EventsWrapper {

    private Iterable<ResponseEvent> events;
}
