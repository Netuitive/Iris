package com.netuitive.iris.entity;

import lombok.Data;
import java.util.Set;

/**
 * @author John King
 */
@Data
public class Metric {

    private Long dataSourceId;
    private String id;
    private String fqn;
    private String name;
    private String unit;
    private String type;
    private SparseDataStrategy sparseDataStrategy;
    private Set<Tag> tags;
}
