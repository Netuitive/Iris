package com.netuitive.iris.entity.wrapper;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 *
 * @author john.king
 */
@Data
public class MetricMetaWrapper {

    private String id;
    private String fqn;
    private Map<String, Object> state = new HashMap<String, Object>();
    private Map<String, Object> configuration = new HashMap<String, Object>();
}
